(defproject something "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [aleph "0.4.4"]
                 [byte-streams "0.2.3"]
                 [cheshire "5.8.0"]
                 [hickory "0.7.1"]
                 [org.clojure/tools.cli "0.3.5"]
                 [manifold "0.1.6"]
                 [clojurewerkz/urly "1.0.0"]]

  :main ^:skip-aot something.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
