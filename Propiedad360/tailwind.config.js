/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        customColor: 'rgba(25, 26, 24, 1)',
        customColor2: 'rgba(195, 146, 46, 1)',
        customColor3: 'rgba(93, 94, 97, 1)',
        customColor4: 'rgba(25, 26, 24, 1)',
        gustomColor6: 'rgba(222, 126, 31, 1)'
      },
      
    },
  },
  plugins: [require("daisyui")],
}