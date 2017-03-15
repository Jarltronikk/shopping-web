(ns shopping-web.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent-modals.modals :as reagent-modals]))

(enable-console-print!)



(defonce app-state (atom {:text "SHOP"}))
(defn main []
  [:div [:h1 (:text @app-state)]
   [:div
    [reagent-modals/modal-window]
    ]
   [:div {:dangerouslySetInnerHTML {:__html "<product-list></product-list>"}}]
   ])

(defn  ^:export launchOrder [uri] (reagent-modals/modal! [:src uri]))

(reagent/render-component [main]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
