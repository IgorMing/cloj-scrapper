(ns something.scraper
    (:refer-clojure :exclude [resolve])
    (:require [aleph.http :as http]
              [hickory.core :refer [parse as-hickory]]
              [hickory.select :as s]
              [byte-streams :as bs]
              [manifold.deferred :as d]
              [clojurewerkz.urly.core :refer [resolve]]))

(defn clean-urls
    [urls]
    (->> urls
        (filter (fn [url]
                    (and (not (nil? url)) (not (empty? url)))))
        (map clojure.string/trim)))


(defn resolve-deep-links
    [base urls]
    (map #(resolve base %) urls))

(defn start-scraping
    [url]
    (let [page-html (d/chain
                        (http/get url)
                        :body
                        bs/to-string)
          html-tree (as-hickory (parse @page-html))
          links (->> (s/select (s/tag :a) html-tree)
                     (map #(get-in % [:attrs :href]))
                     clean-urls
                     (resolve-deep-links url)
                     (into #{}))]
        (println links)))

(defn start
  [url]
  (do
    (println "url:" url)
    (start-scraping url)))
