# AXP - DSP Chapter Website
`Version X` _for now_, becuase who knows how many spinoffs there were.

## Development Prerequisites
Make sure you have `node` aand `npm` installed. For now we are not explicitly using any `node` but developement will use `npm` to get resources and run tasks.

## Development
 1. clone this repository `$git clone https://github.com/Perezjo94/axpdsp-site`
 2. `$ npm install` to get all packages
 3. `$ npm run deploy` - build __CSS__ and __js__
 4. `$ npm start` to run css and js watchers
 5. Open `file://<path/to/repo>/index.html` in your browser
 6. After saving any changes, just refresh th page

## Deployment
For now, we will be using `master` for our site deployment. So for now, follow these steps:

1. `$ npm run deploy` to ensure your latest changes are built
2. Commit and Push your changes
    a. `$ git add .`
    b. `$ git commit -m "<your commit message>"`
    c. `$ git push`

## Hosting
We are using [Github Pages](https://pages.github.com/) to host our site. We are serving the `master` branch until we're ready to actually publish and tie in our domain name. See the [Pages Help](https://help.github.com/categories/github-pages-basics/) if you have questions or problems.

__Note__: the page is not being served _yet..._ stay tuned for now.