(ns axpdsp-site.newsletter
  (:require [reagent.core :as r]
            [cljs.reader :as reader]
            [shadow.resource :as resource]))

(def newsletter (reader/read-string (resource/inline "newsletter.edn")))


(defn ui []
  (let [entry-index (r/atom nil)]
    (fn []
      [:section.section.is-small.has-background-light {:id "newsletter"}
       [:div.container
        [:div.content
         [:h1 "Newsletter - Fresh off the Press"]]
        [:div.columns
         (for [[{:keys [title author position date]}
                idx] (map vector (take 4 newsletter) (range))]
           [:div.column.is-3
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
               [:p.subtitle (apply str author
                                   (when position
                                     [" - " position]))]]]
             [:div.card-footer
              [:a.card-footer-item
               {:style   {:margin-top :auto}
                :onClick #(reset! entry-index idx)}
               "View"]]]])]
        (when @entry-index
          [:div.content.is-medium
           {:dangerouslySetInnerHTML
            {:__html (:html (nth newsletter @entry-index))}}])]])))
