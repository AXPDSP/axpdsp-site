(ns axpdsp-site.data
  (:require [reagent.core :as r]
            [clojure-sheets.core :as sheets]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [clojure.core.async :as a]))

(def brothers (r/atom nil))
(a/go (let [brothers-res (sheets/sheet->map
                          "1o7fckgforDgA_YYQkBFjZtVr7Z2U19DJsnwG5MrMEJE"
                          {:key-fn sheets.key-fns/idiomatic-keyword})]
        (reset! brothers (shuffle (a/<! brothers-res)))))
