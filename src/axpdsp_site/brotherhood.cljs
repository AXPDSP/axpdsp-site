(ns axpdsp-site.brotherhood)

(defn ui []
  [:section.section.is-small {:id "brotherhood"}
   [:div.container
    [:div.columns
     [:div.column.is-6
      [:div.content
       [:h1 "Brotherhood - Our Landmarks"]
       [:p "Alpha Chi Rho’s basic principles are found in the Landmarks, formed
       by the Founders of the Fraternity over a century ago. They culminate in
       the noble traditions of Alpha Chi Rho and represent what our Founders
       believed was the ideal Brotherhood."]
       [:p]
       [:ol
        [:li "Membership from among those who are prepared to realize in word
        and deed, the Brotherhood of all men."]
        [:li "The insistence on a high and clean moral standard."]
        [:li "The paramount duty of Brotherly love among members."]
        [:li "Judgment not by externals, but by intrinsic worth; no one is
        denied membership in Alpha Chi Rho because of race, creed, or
        nationality."]]
       [:p]
       [:p "These are the Landmarks of Alpha Chi Rho; its foundation and its
       heritage. The ideals which they express are to be lived out by every
       Brother of Alpha Chi Rho, not only during his college days, but also
       throughout his life. They are summarized in the exoteric motto of the
       Fraternity:"]
       [:blockquote.is-crow-quote
        [:b "ΑΝΔΡΙΖΕΣΘΕ"]
        "- \"Be Men\" - (Pronounced: An-DREE-zes-theh) "]]]
     [:div.column.is-offset-1.is-5
      [:figure.image.is-3by4
       [:img]]
      [:div.has-text-centered.help
       "Our House at 8 Boynton"]]]]])
