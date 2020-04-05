(ns axpdsp-site.hero
  (:require ["react-scroll" :refer [Link]]))

(defn ui []
  [:section.hero.is-primary.is-fullheight.with-background-image
   [:div.hero-head
    [:nav.navbar]]
   [:div.hero-body
    [:div.container.has-text-centered
     [:h1.title "ALPHA CHI RHO"]
     [:h2.subtitle "Delta Sigma Phi"]
     [:h3.subtitle.subtitle-caption "@WPI"]
     [:div.content
      [:p "Learn more about us here:"]
      [:div.buttons.is-centered
       [:> Link {:to     "brotherhood"
                 :smooth true
                 :class  "button is-link is-inverted is-outlined anchor-link"}
        "Brotherhood"]
       [:> Link {:to     "recruitment"
                 :smooth true
                 :class  "button is-link is-inverted is-outlined anchor-link"}
        "Recruitment"]
       [:> Link {:to     "newsletter"
                 :smooth true
                 :class  "button is-link is-inverted is-outlined anchor-link"}
        "Newsletter"]
       [:> Link {:to     "philanthropy"
                 :smooth true
                 :class  "button is-link is-inverted is-outlined anchor-link"}
        "Philanthropy"]
       [:> Link {:to     "officers"
                 :smooth true
                 :class  "button is-link is-inverted is-outlined anchor-link"}
        "Our Officers"]]]]]
   [:div.hero-footer.has-text-centered
    [:> Link {:to     "brotherhood"
              :smooth true
              :class  "scroll-down-for-more anchor-link"}
     [:p.button.is-small.is-dark.scroll-button
      "scroll down"]
     [:p
      [:span.icon {:style {:font-size "1.5rem"}}
       "⌄"]]]]])
