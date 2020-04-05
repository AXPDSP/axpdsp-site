(ns axpdsp-site.recruitment)

(defn ui []
  [:section.section.is-small {:id "recruitment"}
   [:div.container
    [:div.columns
     [:div.column.is-5
      [:figure.image.is-4by3
       [:img {:src "images/rushcalendar2019.png"
              :alt "A calendar detailing our rush events for 2019." }]]
      [:div.has-text-centered.help
       "Rush Calendar 2019"]]
     [:div.column.is-6
      [:div.content
       [:h1 "Recruitment - Rush Crow!"]
       [:p "Welcome to Alpha Chi Rho-Delta Sigma Phi Chapter recruitment.
       Joining our Social Fraternity is a great way to learn crucial life skills
       outside of the classroom. We believe in positively impacting the
       community while ensuring our members experience personal, academic and
       professional growth. We can’t wait to meet all of our potential
       members."]]]]]])
