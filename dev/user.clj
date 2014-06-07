(ns user
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [hiccup.core :refer (html)]
            [compojure.route :refer (resources not-found)]
            [compojure.core :refer (GET defroutes)]
            [ring.adapter.jetty]
            [ring.util.response :as resp]
            [clojure.java.io :as io]))

(defonce repl-env (reset! cemerick.austin.repls/browser-repl-env
                          (cemerick.austin/repl-env)))


;; Serve all files from resources/public as is. Serve the index page with the
;; REPL connected. In order to connect a REPL to any page, you must make sure the
;; script is added to all HTML files.
(defroutes site
  (GET "/" [] (html [:html
                     [:head
                      [:script {:src "http://fb.me/react-0.9.0.js" }]]
                     [:body
                      [:div#app]
                      [:script {:src "js/out/goog/base.js"}]
                      [:script {:src "js/app.js"}]
                      [:script (browser-connected-repl-js)]]]))
  (resources "/")
  (not-found "page not found"))


(defn run!
  "Call this function to run a server on port 8080"
  []
  (defonce ^:private server
    (ring.adapter.jetty/run-jetty #'site {:port 8080 :join? false}))
  server)

(defn cljs!
  "Once you have started your Clojure REPL, enter the user namespace and run
   this function."
  []
  (cemerick.austin.repls/cljs-repl repl-env))
