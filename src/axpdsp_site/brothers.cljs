(ns axpdsp-site.brothers
  (:require [axpdsp-site.components :as components]
            [axpdsp-site.data :as data]
            ["react-masonry-component" :default Masonry]))

(defn ui []
  (let [brothers @data/brothers]
    [:section.section
     {:id "brothers"}
     [:div.container
      [:div.content.has-text-centered
       [:h1 "Our Brothers"]]
      [:hr]
      [:> Masonry
       {:className "columns"}
       (for [brother (sort-by :scroll brothers)]
         [:<>
          [:div.column.is-hidden-touch
           {:style {:width "25%"}
            :key   (:scroll brother)}
           [components/brother-bio-card brother]]
          [:div.column.is-hidden-desktop
           {:style {:width "100%"}
            :key   (:scroll brother)}
           [components/brother-bio-card brother]]])]]]))
