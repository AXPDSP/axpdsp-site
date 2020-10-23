(ns axpdsp-site.data
  (:require [reagent.core :as r]
            [clojure-sheets.core :as sheets]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [clojure.core.async :as a]))

(def brothers (r/atom nil))
(def house-pictures (r/atom nil))
(def rush-events (r/atom nil))

(a/go (let [brothers-res (sheets/sheet->map
                          "1o7fckgforDgA_YYQkBFjZtVr7Z2U19DJsnwG5MrMEJE"
                          {:key-fn sheets.key-fns/idiomatic-keyword})]
        (reset! brothers (->> (a/<! brothers-res)
                              (filter (every-pred :brother/name))
                              (shuffle)))))

(a/go (let [house-res (sheets/sheet->map
                       "1o7fckgforDgA_YYQkBFjZtVr7Z2U19DJsnwG5MrMEJE"
                       {:key-fn sheets.key-fns/idiomatic-keyword
                        :page  2})]
        (reset! house-pictures (a/<! house-res))))

(a/go (let [rush-res (sheets/sheet->map
                      "1o7fckgforDgA_YYQkBFjZtVr7Z2U19DJsnwG5MrMEJE"
                      {:key-fn sheets.key-fns/idiomatic-keyword
                       :page  3})]
        (reset! rush-events (a/<! rush-res))))
