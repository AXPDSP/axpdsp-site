(ns axpdsp-site.house
  (:require ["react-responsive-carousel" :refer [Carousel]]
            [axpdsp-site.data :as data]
            [reagent.core :as r]))

(defn ui []
  (let [house-selector (r/atom 8)]
    (fn []
      [:section.section.is-small {:id "house"}
       [:div.container
        [:div.columns
         [:div.column.is-6
          [:div.content
           [:h1 "Explore our Houses"]
           [:p "Welcome to Alpha Chi Rho-Delta Sigma Phi Chapter recruitment.
       Joining our Social Fraternity is a great way to learn crucial life skills
       outside of the classroom. We believe in positively impacting the
       community while ensuring our members experience personal, academic and
       professional growth. We can’t wait to meet all of our potential
       members!"]]]
         [:div.column.is-4.is-offset-1
          [:div.tabs.is-centered
           [:ul
            [:li {:class (when (= 8 @house-selector) "is-active")}
             [:a {:onClick #(reset! house-selector 8)} "8 Boynton"]]]
           [:ul
            [:li {:class (when (= 46 @house-selector) "is-active")}
             [:a {:onClick #(reset! house-selector 46)} "46 Wachusett"]]]]
          [:> Carousel {:showThumbs     false
                        :autoPlay       true
                        :showIndicators false
                        :showArrows     false
                        :infiniteLoop   true
                        :showStatus     false}
           (for [{:house-picture/keys [url caption house]}
                 @data/house-pictures
                 :when (= house @house-selector)]
             ^{:key url}
             [:<>
              [:figure.image.is-4by3
               [:img {:src url}]]
              [:div.has-text-centered.help caption]])]]]]])))
