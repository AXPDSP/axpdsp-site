(ns axpdsp-site.hero
  [:require [axpdsp-site.resources :as rs]])

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
       [:a.button.is-link.is-inverted.is-outlined.anchor-link "Brotherhood"]
       (if rs/rushing?
         [:a.button.is-link.is-inverted.is-outlined.anchor-link "Recruitment"]
         [:a.button.is-link.is-inverted.is-outlined.anchor-link "Newsletter"])
       [:a.button.is-link.is-inverted.is-outlined.anchor-link "Philanthropy"]
       [:a.button.is-link.is-inverted.is-outlined.anchor-link "Our Officers"]]]]]
   [:div.hero-footer.has-text-centered
    [:a.scroll-down-for-more.anchor-link {:href "#brotherhood"}
     [:p.button.is-small.is-dark.scroll-button
      "scroll down"]
     [:p
      [:span.icon
       [:i.fas.fa-lg.fa-long-arrow-alt-down]]]]]])
