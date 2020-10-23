(ns axpdsp-site.components
  (:require [reagent.core :as r]
            [axpdsp-site.utils :as utils]))

(defn brother-contact-card
  [{:brother/keys [name scroll exec-position major grad-year email image-url]}]
  [:div.card
   (when image-url
     [:div.card-image
      [:div.figure.image.is-3by4
       [:img {:src     (utils/fix-url-protocol image-url)
              :alt     (str "Portrait of " name)
              :loading :lazy
              :style   {:width "100%"}}]]])
   [:div.card-content
    [:p.has-text-weight-semibold (str name " - " scroll)]
    [:p exec-position]
    [:p major]
    (when grad-year
      [:p (str "Class of " grad-year)])
    (when email
      [:a {:href (str "mailto:" email)}
       email])]])

(defn brother-bio-card [{:brother/keys [name scroll bio grad-year exec-position
                                        major activities image-url]
                         :as           brother}]
  [:div.card
   (when image-url
     [:div.card-image
      [:figure.image.is-3by4
       [:img {:src         (utils/fix-url-protocol image-url)
              :alt         (str "Portrait of " name)
              :style       {:width "100%"}
              #_#_:onError (fn [e]
                             (set! (.-onerror (.-target e)) nil)
                             (set! (.-src (.-target e))
                                   "https://via.placeholder.com/400x500"))}]]])
   [:div.card-content
    [:p.has-text-weight-semibold (str name " - " scroll)]
    [:p exec-position]
    [:p major]
    [:p activities]
    (when grad-year
      [:p (str "Class of " grad-year)])
    [:p bio]]])
