(ns axpdsp-site.data
  (:require [reagent.core :as r]
            [clojure-sheets.core :as sheets]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [clojure.core.async :as a]))

(def brothers (r/atom nil))
(def house-pictures (r/atom nil))
(def rush-events (r/atom nil))

(a/go (let [brothers-res (sheets/sheet->map
                          "1XL-bbECqaFvlojrRz2g-K_jrusmd8sz0Pj-qoycakdo"
                          "Newest Responses"
                          {:key-fn sheets.key-fns/idiomatic-keyword})]
        (reset! brothers
                (->> (a/<! brothers-res)
                     (filter
                      #(= "Yes"
                          (:make-my-information-visible-on-the-chapter-website? %)))
                     shuffle
                     vec))))

(a/go (let [rush-res (sheets/sheet->map
                      "1El7AF_OReo2qZqSrskB6DAAkN-v6EHchO-pP8ch1xD8"
                      nil
                      {:key-fn sheets.key-fns/idiomatic-keyword})]
        (reset! rush-events (a/<! rush-res))))
