(ns something.core
  (:require [something.scraper :as scraper]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  [["-u" "--url URL" "URL to start scraping"]])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [parsed-opts (parse-opts args cli-options)]
      (scraper/start (get-in parsed-opts [:options :url]))))
