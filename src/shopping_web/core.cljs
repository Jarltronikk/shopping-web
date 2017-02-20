(ns shopping-web.core
  (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "This text is printed from src/shopping-web/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "SHOP"}))

(defn main []
  [:div [:h1 (:text @app-state)]
   [:div {:dangerouslySetInnerHTML {:__html "<product-list></product-list>"}}]
   ])

(reagent/render-component [main]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
