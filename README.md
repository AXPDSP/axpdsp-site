# AXP - DSP Chapter Website
_`Version X`_, _for now_, becuase who knows how many spinoffs there were.

## Development Prerequisites
Make sure you have `node` aand `npm` installed. For now we are not explicitly using any `node` but developement will use `npm` to get resources and run tasks.

## Development
 1. clone this repository `$git clone https://github.com/Perezjo94/axpdsp-site`
 2. `$ npm install` to get all packages
 3. `$ npm start` to run a dev server 
 4. Open `localhost:1234` in your browser
 5. On code change + save the server will automatically refresh with latest changes

## Deployment
We use our `gh-pages` branch for our site deployment. So, follow these steps:

1. `$ npm run build` to ensure your latest changes are built to `/dist`
2. Commit and Push (to `master`) and run `deploy`
    1. `$ git add .`
    2. `$ git commit -m "<your commit message>"`
    Note: only commited changes can be deployed
    3. `$ npm run deploy`
3. Your changes should be deployed

## Hosting
We are using [Github Pages](https://pages.github.com/) to host our site. We are serving the `gh-pages`. See the [Pages Help](https://help.github.com/categories/github-pages-basics/) if you have questions or problems for more on this.