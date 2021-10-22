(ns axpdsp-site.core
  (:require [reagent.dom :as rdom]
            [axpdsp-site.resources :as rs]
            [axpdsp-site.hero :as hero]
            [axpdsp-site.brotherhood :as brotherhood]
            [axpdsp-site.footer :as footer]
            [axpdsp-site.officers :as officers]
            [axpdsp-site.philanthropy :as philanthropy]
            [axpdsp-site.recruitment :as recruitment]))

(defn ui []
  [:<>
   [hero/ui]
   [brotherhood/ui]
   [recruitment/ui]
   [philanthropy/ui]
   [officers/ui]
   [footer/ui]])

(defn render
  []
  (rdom/render [ui]
               (js/document.getElementById "app")))

(defn ^:dev/after-load clear-cache-and-render!
  []
  (render))

(defn init! []
  (render))
