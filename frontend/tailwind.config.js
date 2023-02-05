/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode:"class",
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors :{
        primary: '#5843E4',
        secondary: '#8186A0',
        bglight: '#F9F9FC',
        gray:'#8186a0',
        colordark:'#2F2E41',
      },
    },
  },
  plugins: [],
}
