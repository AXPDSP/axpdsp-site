(ns axpdsp-site.resources
  "Define values loaded from resources."
  (:require [cljs.reader :as reader]
            [shadow.resource :as resource]))

(def newsletter (reader/read-string (resource/inline "newsletter.edn")))

(def rushing? false)
