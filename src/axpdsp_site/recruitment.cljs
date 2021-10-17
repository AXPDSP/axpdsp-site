(ns axpdsp-site.recruitment
  (:require
   [axpdsp-site.data :as data]
   [clojure.string :as str]
   [axpdsp-site.components :as components]))

(defn rush-events []
  (let [rush-events @data/rush-events]
    [:div.columns.is-multiline
     (for [{:rush.event/keys      [name location link]
            :rush.event.date/keys [month day]}
           rush-events]
       ^{:key (str name month day)}
       [:div.column.is-4
        [:div.card
         [:div.card-content
          [:p.has-text-weight-semibold name]
          [:p (str month " " day)]
          (if link
            [:a {:href link} location]
            [:p location])]]])]))

(defn ui []
  (let [rush-person? (fn [{:keys [position]}]
                       (let [position (str/lower-case (or position ""))]
                         (or (str/includes? position "rush")
                             (= position "president"))))
        rush-people  (->> @data/brothers
                          (filter rush-person?)
                          (sort-by :scroll))]
    [:<>
     [:section.section.is-small {:id "recruitment"}
      [:div.container
       [:div.columns
        [:div.column.is-7
         [rush-events]]
        [:div.column.is-4.is-offset-1
         [:div.content
          [:h1 "Recruitment - Rush Crow!"]
          [:p "Welcome to Alpha Chi Rho-Delta Sigma Phi Chapter recruitment.
       Joining our Social Fraternity is a great way to learn crucial life skills
       outside of the classroom. We believe in positively impacting the
       community while ensuring our members experience personal, academic and
       professional growth. We can’t wait to meet all of our potential
       members!"]]]]]]
     [:section.section.has-background-light
      [:div.container
       [:div.content.has-text-centered
        [:h1 "Your Rush Contacts"]
        [:a.button
         {:href "https://discord.gg/JfjHh7FPk4"}
         "Join our Discord"]]
       [:div.columns.is-variable.is-8
        (for [{:keys [scroll]
               :as   rush-person} rush-people]
          [:div.column.is-4
           {:key scroll}
           [components/brother-contact-card rush-person]])]]]]))
