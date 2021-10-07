(ns axpdsp-site.footer)

(defn ui []
  [:<>
   [:section.section
    [:div.container.has-text-centered
     [:p.subtitle
      "For inquiries, please send an email to "
      [:a {:href "mailto:axp-chapercorr@wpi.edu"}
       "axp-chapercorr@wpi.edu"]]]]
   [:footer.footer.has-background-white
    [:div.container
     [:div.columns
      [:div.column.is-3.is-offset-2
       [:h2 [:strong "University"]]
       [:ul
        [:li [:a {:href "https://www.wpi.edu/"} "WPI Home"]]
        [:li [:a {:href "https://www.wpi.edu/student-experience/getting-involved/fraternities-sororities"}
              "WPI Fraternity Resources"]]
        [:li [:a {:href "https://wpi.campuslabs.com/engage/organization/alpha-chi-rho-fraternity"}
              "WPI TechSync"]]]]
      [:div.column.is-3
       [:h2 [:strong "Graduate Chapter"]]
       [:ul
        [:li [:a {:href "http://www.axpdspgrads.com/"} "Graduate Website"]]]]
      [:div.column.is-4
       [:h2 [:strong "National Fraternity"]]
       [:ul
        [:li [:a {:href "http://www.alphachirho.org/"} "National Website"]]
        [:li [:a {:href "http://www.alphachirho.org/foundation/"}
              "AXP Educational Foundation"]]
        [:li [:a {:href "https://www.facebook.com/AlphaChiRhoHQ/"}
              "National Facebook Page"]]]]]]]])
