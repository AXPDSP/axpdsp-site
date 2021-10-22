(ns axpdsp-site.officers
  (:require [axpdsp-site.data :as data]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [axpdsp-site.components :as components]
            [clojure.string :as str]))

(def officers-order
  "Defines the order in which officers are displayed."
  ["President" "Vice President" "Secretary" "Treasurer" "House Manager" "Steward"
   "Social Officer" "Member-at-Large" "Risk Management Officer"])

(defn ui []
  (let [brothers @data/brothers]
    [:section.section.section-with-sidebar.has-background-light
     {:id :officers}
     [:div.columns.is-marginless
      [:div.column.is-one-quarter.notification.is-primary.has-text-centered.section-sidebar
       [:div.sidebar-title.level
        {:style {:margin-bottom "5rem"}}
        [:p.level-item.title "Executive Officers"]]]
      [:div.column
       {:style {:padding "4rem"}}
       [:div.columns.is-multiline.is-8.is-variable
        (when brothers
          (for [brother (data/with-positions officers-order brothers)
                :let    [key (:scroll brother)]]
            ^{:key key}
            [:div.column.is-one-third
             [components/brother-contact-card brother]]))]]]]))
