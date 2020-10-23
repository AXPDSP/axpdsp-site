(ns axpdsp-site.officers
  (:require [axpdsp-site.data :as data]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [axpdsp-site.components :as components]
            [clojure.string :as str]))

(def officers-order
  "Defines the order in which officers are displayed."
  [:president :vice-president :secretary :treasurer :house-manager :steward
   :social-officer :member-at-large :risk-manager])

(defn brother->position [{:brother/keys [exec-position name]}]
  (when exec-position
    (some identity
          ;; Reverse so that Vice President is checked before President
          (for [position (reverse officers-order)] 
            (when (str/includes? (str/lower-case exec-position)
                                 (str/replace (clojure.core/name position)
                                              #"-" " "))
              position)))))

(defn ui []
  (let [officers (group-by brother->position @data/brothers)]
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
        (when officers
          (for [position officers-order
                :let
                [brother (first (position officers))]
                :when    brother
                :let     [key (:brother/scroll brother)]]
            ^{:key key}
            [:div.column.is-one-third
             [components/brother-contact-card brother]]))]]]]))
