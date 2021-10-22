(ns axpdsp-site.components
  (:require [reagent.core :as r]
            [axpdsp-site.utils :as utils]
            [clojure.string :as str]))

(defn brother-contact-card
  []
  (let [error (r/atom nil)]
    (fn [{:keys [name scroll positions major school-email portrait]}]
      [:div.card
       (when (and portrait (not @error))
         [:div.card-image
          [:div.figure.image.is-3by4
           [:img {:src     (utils/fix-url-protocol portrait)
                  :alt     (str "Portrait of " name)
                  :loading :lazy
                  :style   {:width      "100%"
                            :object-fit :cover}
                  :onError (fn [e]
                             (reset! error true))}]]])
       [:div.card-content
        [:p.has-text-weight-semibold  name]
        [:p (str/join ", " positions)]
        (when school-email
          [:a {:href (str "mailto:" school-email)}
           school-email])]])))

(defn brother-bio-card []
  (let [error (r/atom nil)
        sc    (r/atom nil)]
    (fn [{:keys [name scroll bio positions major year-of-graduation portrait]}]
      (when (not= scroll @sc)
        (reset! error false))
      [:div.card
       (when (and portrait (not @error))
         [:div.card-image
          [:figure.image.is-3by4
           [:img {:src     (utils/fix-url-protocol portrait)
                  :alt     (str "Portrait of " name)
                  :style   {:width      "100%"
                            :object-fit :cover}
                  :onError (fn [e]
                             (reset! sc scroll)
                             (reset! error true))}]]])
       [:div.card-content
        [:p.has-text-weight-semibold name]
        [:p (str "Scroll " scroll)]
        [:p (str/join ", " positions)]
        [:p (str/join ", " major)]
        [:p (str "Class of " year-of-graduation)]
        (when bio
          [:<>
           [:br]
           [:p bio]])]])))
