(ns axpdsp-site.newsletter
  (:require [reagent.core :as r]
            [cljs.reader :as reader]
            [shadow.resource :as resource]))

(def newsletter (reader/read-string (resource/inline "newsletter.edn")))


(defn ui []
  (let [entry-index (r/atom 0)]
    (fn []
      [:section.section.is-small.has-background-light {:id "newsletter"}
       [:div.container
        [:div.columns
         [:div.column.is-6
          [:div.content
           [:h1 "Newsletter - Fresh off the Press"]]
          [:div.columns
           (for [[{:keys [title author position date]}
                  idx] (map vector (take 6 newsletter) (range))]
             [:div.column.is-6
              {:key idx}
              [:div.card
               {:style {:height         "100%"
                        :display        :flex
                        :flex-direction :column}}
               [:div.card-content
                {:style {:height "100%"}}
                [:div.media-content
                 [:p.title title]
                 [:p.subtitle (.format (js/Intl.DateTimeFormat.
                                        "en-US"
                                        #js {:day   "numeric"
                                             :month "long"
                                             :year  "numeric"})
                                       date)]
                 [:p.subtitle (str author " - " position)]]]
               [:div.card-footer
                [:a.card-footer-item
                 {:style   {:margin-top :auto}
                  :onClick #(reset! entry-index idx)}
                 "View"]]]])]]
         [:div.column.is-offset-1.is-5
          [:div.content {:dangerouslySetInnerHTML
                         {:__html (:html (nth newsletter @entry-index))}}]]]]])))
