(defproject app "0.1.0-SNAPSHOT"
  :source-paths ["src" "dev"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2227"]
                 ;; Web server stuff
                 [ring "1.3.0"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [om "0.6.4"]]
  :profiles {:dev {:plugins [[com.cemerick/austin "0.1.4"]
                             [lein-cljsbuild "1.0.3"]]
                   :cljsbuild {:builds [{:id "app"
                                         :source-paths ["src" "dev"]
                                         :compiler {
                                                    :output-to "resources/public/js/app.js"
                                                    :optimizations :whitespace}}]}}})
