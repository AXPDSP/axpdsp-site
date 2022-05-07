(ns axpdsp-site.brotherhood
  (:require [axpdsp-site.data :as data]
            [axpdsp-site.components :as components]
            [reagent.core :as r]))

(defn cycle-vector
  "Returns a new vector "
  [[head & more]]
  (when head
    (let [v (vec more)]
      (conj v head))))

(defn cycle-brothers [brothers]
  (if-not (empty? (:portrait (first (cycle-vector brothers))))
    (cycle-vector brothers)
    (cycle-brothers (cycle-vector brothers))))

(defonce
  ^{:doc "A timer to update the brother shown every 7.5 seconds"}
  brother-cycle
  (js/setInterval (fn []
                    (swap! data/brothers cycle-brothers))
                  7500))


(defn ui []
  (let [brothers @data/brothers 
        brother  (first brothers)]
    [:section.section.is-small.has-background-light
     {:id "brotherhood" :style {:min-height "100vh"
                                :max-width  "100vw"
                                :position   :relative}}
     [:div.container
      [:div.columns
       [:div.column.is-6
        [:div.content
         [:h1 "Brotherhood - Our Landmarks"]
         [:p "Alpha Chi Rho’s basic principles are found in the Landmarks,
             formed by the Founders of the Fraternity over a century ago. They
             culminate in the noble traditions of Alpha Chi Rho and represent
             what our Founders believed was the ideal Brotherhood."]
         [:p]
         [:ol
          [:li "Membership from among those who are prepared to realize in
              word and deed, the Brotherhood of all men."]
          [:li "The insistence on a high and clean moral standard."]
          [:li "The paramount duty of Brotherly love among members."]
          [:li "Judgment not by externals, but by intrinsic worth; no one is
              denied membership in Alpha Chi Rho because of race, creed,
              nationality, or sexual orientation."]]
         [:p]
         [:p "These are the Landmarks of Alpha Chi Rho; its foundation and
             its heritage. The ideals which they express are to be lived out by
             every Brother of Alpha Chi Rho, not only during his college days,
             but also throughout his life. They are summarized in the exoteric
             motto of the Fraternity:"]
         [:blockquote.is-crow-quote
          [:b "ΑΝΔΡΙΖΕΣΘΕ"]
          " - \"Be Men\" - (Pronounced: An-DREE-zes-theh) "]]]
       (when brother
         [:div.column.is-3.is-offset-2.is-hidden-touch
          [components/brother-bio-card brother]])]]]))
