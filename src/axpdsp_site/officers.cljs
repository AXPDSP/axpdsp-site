(ns axpdsp-site.officers
  (:require [clojure.string :as str]))

(def officers
  "A map of positions to names."
  {:president       "Alex Marzoratti"
   :vice-president  "Johnny Chea"
   :secretary       "Daniel Ribaudo"
   :treasurer       "Joshua Angel"
   :house-manager   "Samuel Talpey"
   :steward         "Andrew Fisher"
   :member-at-large "Eamon Oldridge"
   :social-officer  "Ethan Davis"
   :risk-manager    "Stephen Weaver"})

(def officers-order
  "Defines the order in which officers are displayed."
  [:president :vice-president :secretary :treasurer :house-manager :steward
   :social-officer :member-at-large :risk-manager])

(defn position-name
  "Converts a `position` in keyword format to a string."
  [position]
  (-> position
      name
      (str/split #"-")
      (->> (map str/capitalize)
           (str/join " "))))

(defn ui []
  [:section.section.section-with-sidebar.has-background-light {:id :officers}
   [:div.columns.is-marginless
    [:div.column.is-one-quarter.notification.is-primary.has-text-centered.section-sidebar
     [:div.sidebar-title.level
      {:style {:margin-bottom "5rem"}}
      [:p.level-item.title "Executive Officers"]]]
    [:div.column
     {:style {:margin "4rem"}}
     [:div.columns.is-multiline.is-8.is-variable
      (for [officer officers-order]
        [:div.column.is-one-third {:key officer}
         [:div.card
          [:div.card-image
           [:img {:src     (str "images/officers/" (name officer) ".jpeg")
                  :alt     (str "Portrait of " (officer officers))
                  :loading :lazy
                  :style   {:width "100%"}}]]
          [:div.card-content
           [:p.has-text-weight-semibold (officer officers)]
           [:p (position-name officer)]]]])]]]])
