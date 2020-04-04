(ns axpdsp-site.hero)

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
       [:a.button.is-link.is-inverted.is-outlined.anchor-link
        {:href "#brotherhood"}
        "Brotherhood"]
       [:a.button.is-link.is-inverted.is-outlined.anchor-link
        {:href "#recruitment"}
        "Recruitment"]
       [:a.button.is-link.is-inverted.is-outlined.anchor-link
        {:href "#newsletter"}
        "Newsletter"]
       [:a.button.is-link.is-inverted.is-outlined.anchor-link
        {:href "#philanthropy"}
        "Philanthropy"]
       [:a.button.is-link.is-inverted.is-outlined.anchor-link
        {:href "#officers"}
        "Our Officers"]]]]]
   [:div.hero-footer.has-text-centered
    [:a.scroll-down-for-more.anchor-link {:href "#brotherhood"}
     [:p.button.is-small.is-dark.scroll-button
      "scroll down"]
     [:p
      [:span.icon {:style {:font-size "1.5rem"}}
       "⌄"]]]]])
