# AXP - DSP Chapter Website
`Version X`, _for now_, becuase who knows how many spinoffs there were.

## Development Prerequisites
Make sure you have `node` aand `npm` installed. For now we are not explicitly using any `node` but developement will use `npm` to get resources and run tasks.

## Development
 1. clone this repository `$git clone https://github.com/Perezjo94/axpdsp-site`
 2. `$ npm install` to get all packages
 3. `$ npm start` to run a dev server 
 4. Open `localhost:1234` in your browser
 5. On code change + save the server will automatically refresh with latest changes

## Deployment
For now, we will be using `master` for our site deployment. So for now, follow these steps:

1. `$ npm run build` to ensure your latest changes are built
2. Commit and Push your changes
    1. `$ git add .`
    2. `$ git commit -m "<your commit message>"`
    3. `$ git push`

## Hosting
We are using [Github Pages](https://pages.github.com/) to host our site. We are serving the `master` branch until we're ready to actually publish and tie in our domain name. See the [Pages Help](https://help.github.com/categories/github-pages-basics/) if you have questions or problems.

__Note__: the page is not being served _yet..._ stay tuned for now.