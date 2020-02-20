/**
 * 音标app
 */
let vmData = {
    data: {
        vowels: [],
        consonants: []
    }
};
let vm = new Vue({
    el: "#vue-container",
    data: vmData,
    created: function () {
        commonUtils.getAjax(_ctx + "app/phonetics", function (data) {
            vmData.data.vowels = data.data.vowels;
            vmData.data.consonants = data.data.consonants;
        });
    },
    methods: {
        playPhonogram: async function (phonogram) {
            let audio = document.createElement('audio');
            let source = document.createElement('source');
            source.type = "audio/mpeg";
            let explorer = navigator.userAgent;
            let isFirefoxOrOpera = explorer.indexOf("Firefox") >= 0 || explorer.indexOf("Opera") >= 0;
            source.src = _ctx + "" + (isFirefoxOrOpera ? phonogram.kkWavPath : phonogram.kkMp3Path);
            source.autoplay = "autoplay";
            source.controls = "controls";
            audio.appendChild(source);
            await audio.play();
        }
    },
    mounted: function () {

    }
});