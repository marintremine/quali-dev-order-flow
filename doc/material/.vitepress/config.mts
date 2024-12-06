import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "Order flow material",
  description: "Material for order flow practical work",
  outDir: '../../public/material',
  base: '/quali-dev-order-flow/material/',
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    search: {
      provider: 'local'
    },
    socialLinks: [
      {
        icon: {
          svg: '<svg xmlns="http://www.w3.org/2000/svg" height="150" viewBox="90 90 210 210" width="150"><defs><style>.cls-1{fill:#e24329;}.cls-2{fill:#fc6d26;}.cls-3{fill:#fca326;}</style></defs><g id="LOGO"><path class="cls-1" d="M282.83,170.73l-.27-.69-26.14-68.22a6.81,6.81,0,0,0-2.69-3.24,7,7,0,0,0-8,.43,7,7,0,0,0-2.32,3.52l-17.65,54H154.29l-17.65-54A6.86,6.86,0,0,0,134.32,99a7,7,0,0,0-8-.43,6.87,6.87,0,0,0-2.69,3.24L97.44,170l-.26.69a48.54,48.54,0,0,0,16.1,56.1l.09.07.24.17,39.82,29.82,19.7,14.91,12,9.06a8.07,8.07,0,0,0,9.76,0l12-9.06,19.7-14.91,40.06-30,.1-.08A48.56,48.56,0,0,0,282.83,170.73Z"/><path class="cls-2" d="M282.83,170.73l-.27-.69a88.3,88.3,0,0,0-35.15,15.8L190,229.25c19.55,14.79,36.57,27.64,36.57,27.64l40.06-30,.1-.08A48.56,48.56,0,0,0,282.83,170.73Z"/><path class="cls-3" d="M153.43,256.89l19.7,14.91,12,9.06a8.07,8.07,0,0,0,9.76,0l12-9.06,19.7-14.91S209.55,244,190,229.25C170.45,244,153.43,256.89,153.43,256.89Z"/><path class="cls-2" d="M132.58,185.84A88.19,88.19,0,0,0,97.44,170l-.26.69a48.54,48.54,0,0,0,16.1,56.1l.09.07.24.17,39.82,29.82s17-12.85,36.57-27.64Z"/></g></svg>'
        },
        link: 'https://gitlab.cloud0.openrichmedia.org/iuto/quali-dev-order-flow',
        ariaLabel: 'Gitlab repository'
      }
    ]
  },
  locales: {
    root: {
      label: "English",
      lang: "en",
      link: '/en',
      themeConfig: {
        nav: [
          { text: 'Home', link: '/en' },
          { text: 'Project presentation', link: '/en/project-presentation' },
          {
            text: 'Practical work', items: [
              { text: 'Main page', link: '/en/practical-work/index' },
            ]
          }
        ],

        sidebar: [
          {
            text: 'Project presentation',
            link: '/en/project-presentation'
          },
          {
            text: 'Practical work',
            items: [
              { text: 'Main page', link: '/en/practical-work/' },
              { text: 'Exercise 1', link: '/en/practical-work/exercise-1' },
              { text: 'Exercise 2', link: '/en/practical-work/exercise-2' },
              { text: 'Exercise 3', link: '/en/practical-work/exercise-3' },
              { text: 'Exercise 4', link: '/en/practical-work/exercise-4' },
              { text: 'Exercise 5', link: '/en/practical-work/exercise-5' },
              // { text: 'Exercise 6', link: '/en/practical-work/exercise-6' },
              // { text: 'Exercise 7', link: '/en/practical-work/exercise-7' },
              // { text: 'Exercise 8', link: '/en/practical-work/exercise-8' },
              // { text: 'Exercise 9', link: '/en/practical-work/exercise-9' },
            ]
          }
        ],
      }
    },
    fr: {
      label: "Français",
      lang: "fr",
      link: '/fr',
      themeConfig: {
        nav: [
          { text: 'Accueil', link: '/fr' },
          { text: 'Présentation du projet', link: '/fr/presentation-projet' },
          {
            text: 'Travail pratique', items: [
              { text: 'Page principale', link: '/fr/travail-pratique/' },
            ]
          }
        ],

        sidebar: [
          {
            text: 'Présentation du projet',
            link: '/fr/presentation-projet'
          },
          {
            text: 'Travail pratique',
            items: [
              { text: 'Page principale', link: '/fr/travail-pratique/' },
              { text: 'Exercice 1', link: '/fr/travail-pratique/exercice-1' },
              { text: 'Exercice 2', link: '/fr/travail-pratique/exercice-2' },
              { text: 'Exercice 3', link: '/fr/travail-pratique/exercice-3' },
              { text: 'Exercice 4', link: '/fr/travail-pratique/exercice-4' },
              { text: 'Exercice 5', link: '/fr/travail-pratique/exercice-5' },
              // { text: 'Exercice 6', link: '/fr/travail-pratique/exercice-6' },
              // { text: 'Exercice 7', link: '/fr/travail-pratique/exercice-7' },
              // { text: 'Exercice 8', link: '/fr/travail-pratique/exercice-8' },
              // { text: 'Exercice 9', link: '/fr/travail-pratique/exercice-9' },
            ]
          }
        ],
      }
    }
  }
})
