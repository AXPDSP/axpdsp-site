(ns axpdsp-site.philanthropy)

(defn ui []
  [:section.section.is-small {:id "philanthropy"}
   [:div.container
    [:div.columns
     [:div.column.is-6
      [:div.content
       [:h1 "Philanthropy - Making a Difference"]
       [:p "The members of Alpha Chi Rho-Delta Sigma Phi Chapter hold
       philanthropy very close to their hearts. Our chapter is pleased to
       continue our partnerships with philanthropic organizations, and we are
       proud to be making a difference in the lives of many. Our primary
       philanthropic partner organization is "
        [:a {:href "https://www.habitat.org/"}
         "Habitat for Humanity."]]]]
     [:div.column.is-offset-1.is-5
      [:figure.image.is-4by3
       [:img {:src     "images/group/restore_shift.jpg"
              :loading :lazy
              :alt "Alpha Chi Rho Brothers at a Habitat for Humanity ReStore shift" }]]
      [:div.has-text-centered.help
       "Arthritis Foundation's Walk for a Cure, Worcester, MA"]]]]])
