(ns axpdsp-site.brotherhood
  (:require [axpdsp-site.data :as data]))

(defn cycle-vector
  "Returns a new vector "
  [[head & more]]
  (when head
    (let [v (vec more)]
      (conj v head))))

(defonce
  ^{:doc "A timer to update the brother shown every 7.5 seconds"}
  brother-cycle
  (js/setInterval #(swap! data/brothers cycle-vector)
                  7500))

(defn ui []
  [:section.section.is-small.has-background-light.is-flex
   {:id "brotherhood" :style {:min-height "100vh"}}
   [:div.container.is-flex.is-vcentered
    [:div.columns.is-vcentered
     [:div.column.is-6
      [:div.content
       [:h1 "Brotherhood - Our Landmarks"]
       [:p "Alpha Chi Rho’s basic principles are found in the Landmarks, formed
       by the Founders of the Fraternity over a century ago. They culminate in
       the noble traditions of Alpha Chi Rho and represent what our Founders
       believed was the ideal Brotherhood."]
       [:p]
       [:ol
        [:li "Membership from among those who are prepared to realize in word
        and deed, the Brotherhood of all men."]
        [:li "The insistence on a high and clean moral standard."]
        [:li "The paramount duty of Brotherly love among members."]
        [:li "Judgment not by externals, but by intrinsic worth; no one is
        denied membership in Alpha Chi Rho because of race, creed, or
        nationality."]]
       [:p]
       [:p "These are the Landmarks of Alpha Chi Rho; its foundation and its
       heritage. The ideals which they express are to be lived out by every
       Brother of Alpha Chi Rho, not only during his college days, but also
       throughout his life. They are summarized in the exoteric motto of the
       Fraternity:"]
       [:blockquote.is-crow-quote
        [:b "ΑΝΔΡΙΖΕΣΘΕ"]
        " - \"Be Men\" - (Pronounced: An-DREE-zes-theh) "]]]
     (let [{:brother/keys [name scroll bio grad-year exec-position major
                           activities]
            :as           brother}
           (first @data/brothers)]
       (when brother
         [:div.column.is-offset-2.is-4
          [:div.card
           [:div.card-image
            [:figure.image.is-4by5
             [:img {:src         (str "images/brothers/" scroll ".jpeg")
                    :alt         (str "Portrait of " name)
                    :style       {:width "100%"}
                    #_#_:onError (fn [e]
                                   (set! (.-onerror (.-target e)) nil)
                                   (set! (.-src (.-target e))
                                         "https://via.placeholder.com/400x500"))}]]]
           [:div.card-content
            [:p.has-text-weight-semibold (str name " - " scroll)]
            [:p exec-position]
            [:p major]
            [:p activities]
            (when grad-year
              [:p (str "Class of " grad-year)])
            [:p bio]]]]))]]])
