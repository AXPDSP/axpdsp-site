(ns axpdsp-site.officers
  (:require [clojure.string :as str]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [axpdsp-site.data :as data]))

(def officers-order
  "Defines the order in which officers are displayed."
  [:president :vice-president :secretary :treasurer :house-manager :steward
   :social-officer :member-at-large :risk-manager])

(defn officer [{:brother/keys [name scroll exec-position]}]
  [:div.column.is-one-third
   [:div.card
    [:div.card-image
     [:img {:src     (str "images/brothers/" scroll ".jpeg")
            :alt     (str "Portrait of " name)
            :loading :lazy
            :style   {:width "100%"}}]]
    [:div.card-content
     [:p.has-text-weight-semibold name]
     [:p exec-position]]]])

(defn ui []
  (let [officers (group-by (comp (fnil sheets.key-fns/idiomatic-keyword "")
                                 :brother/exec-position)
                           @data/brothers)]
    [:section.section.section-with-sidebar.has-background-light {:id :officers}
     [:div.columns.is-marginless
      [:div.column.is-one-quarter.notification.is-primary.has-text-centered.section-sidebar
       [:div.sidebar-title.level
        {:style {:margin-bottom "5rem"}}
        [:p.level-item.title "Executive Officers"]]]
      [:div.column
       {:style {:padding "4rem"}}
       [:div.columns.is-multiline.is-8.is-variable
        (when officers
          (for [position officers-order
                :let
                [brother (first (position officers))]
                :when    brother
                :let     [key (:brother/scroll brother)]]
            ^{:key key}
            [officer brother]))]]]]))
