(ns axpdsp-site.core
  (:require [reagent.dom :as rdom]
            [axpdsp-site.resources :as rs]
            [axpdsp-site.hero :as hero]
            [axpdsp-site.brotherhood :as brotherhood]
            [axpdsp-site.philanthropy :as philanthropy]))

(defn ui []
  [:div
   [hero/ui]
   [brotherhood/ui]
   [philanthropy/ui]])

(defn render
  []
  (rdom/render [ui]
               (js/document.getElementById "app")))

(defn ^:dev/after-load clear-cache-and-render!
  []
  (render))

(defn init! []
  (render))
