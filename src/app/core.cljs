(ns app.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

;; Lets you do (prn "stuff") to the console
(enable-console-print!)  

(def app-state
  (atom {:things [""]})) 

(defn test-om-app [app owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil
        (dom/h1 nil "ready!")))))    

(om/root test-om-app app-state {:target (.getElementById js/document "app")})

