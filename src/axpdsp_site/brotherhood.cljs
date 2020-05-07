(ns axpdsp-site.brotherhood
  (:require [clojure-sheets.core :as sheets]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [clojure.core.async :as a]
            [reagent.core :as r]))

(def brothers (r/atom nil))
(a/go (let [brothers-res (sheets/sheet->map
                          "1o7fckgforDgA_YYQkBFjZtVr7Z2U19DJsnwG5MrMEJE"
                          {:key-fn sheets.key-fns/idiomatic-keyword})]
        (reset! brothers (shuffle (a/<! brothers-res)))))

(defn cycle-vector
  "Returns a new vector "
  [[head & more]]
  (when head
    (let [v (vec more)]
     (conj v head))))

(defonce
  ^{:doc "A timer to update the brother shown every 5 seconds"}
  brother-cycle
  (js/setInterval #(swap! brothers cycle-vector)
                  5000))

(defn ui []
  [:section.section.is-small.has-background-light {:id "brotherhood"}
   [:div.container
    [:div.columns
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
     (let [{:brother/keys [name scroll bio postulancy-year image-url]
            :as brother}
           (first @brothers)]
       (when brother
         [:div.column.is-offset-1.is-5
          [:div.card
           [:div.card-image
            [:figure.image.is-square
             [:img {:src   image-url
                    :alt   (str "Portrait of " name)
                    :style {:width "100%"}}]]]
           [:div.card-content
            [:p.has-text-weight-semibold (str name " - " scroll)]
            [:p (str "Postulancy Year " postulancy-year)]
            [:p bio]]]]))]]])
