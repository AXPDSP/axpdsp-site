(ns axpdsp-site.newsletter
  (:require [axpdsp-site.resources :as resources]))

(defn ui []
  [:section.section.is-small {:id "newsletter"}
   [:div.container
    [:div.columns
     [:div.column.is-5
      [:div.content
       [:h1 "Newsletter - Fresh off the Press"]]]
     [:div.column.is-offset-1.is-6
      [:div.content {:dangerouslySetInnerHTML
                     {:__html (:html (first resources/newsletter))}}]]]]])
