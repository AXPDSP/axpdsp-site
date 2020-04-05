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
       proud to be making a difference in the lives of many. The following are
       the primary organizations that we work with."]]]
     [:div.column.is-offset-1.is-5
      [:figure.image.is-4by3
       [:img {:src     "images/group/arthritis_walk.jpeg"
              :loading :lazy
              :alt     "Alpha Chi Rho Brothers at Arthritis Foundation's Walk for a
              Cure in Worcester, MA" }]]
      [:div.has-text-centered.help
       "Arthritis Foundation's Walk for a Cure, Worcester, MA"]]]]
   [:nav.level.philanthropy-items
    [:a.button.is-primary.level-item
     {:href "https://www.feedthechildren.org/"}
     "FEED THE CHILDREN"]
    [:a.button.is-primary.level-item
     {:href "https://www.autism-society.org/"}
     "AUTISM SOCIETY OF AMERICA"]
    [:a.button.is-primary.level-item
     {:href "https://childrenswish.org/"}
     "CHILDREN'S WISH FOUNDATION"]
    [:a.button.is-primary.level-item
     {:href "https://www.cancer.org/"}
     "AMERICAN CANCER SOCIETY"]
    [:a.button.is-primary.level-item
     {:href "https://www.habitat.org/"}
     "HABITAT FOR HUMANITY"]]])
