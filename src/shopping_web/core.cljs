(ns shopping-web.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent-modals.modals :as reagent-modals]))

(enable-console-print!)


(defonce app-state (atom {:text "SHOP"}))
(defn main []
  [:div
   [:div
    [reagent-modals/modal-window]
    ]
   [:h1 (:text @app-state)]
   [:div {:dangerouslySetInnerHTML {:__html "<product-list></product-list>"}}]
   ])

(defn ^:export launchOrder [uri]
  (reagent-modals/modal!
    [:div {:dangerouslySetInnerHTML {:__html (str "<order-view order='" uri "'></order-view>")}}]))
(reagent/render-component [main]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
