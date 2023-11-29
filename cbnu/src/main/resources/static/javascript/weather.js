const getJSON = function(url, callback) {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function() {
        const status = xhr.status;
        if(status === 200) {
            callback(null, xhr.response);
        } else {
            callback(status, xhr.response);
        }
    };
    xhr.send();
};

getJSON('http://api.openweathermap.org/data/2.5/weather?q=cheongju-si&appid=6b64bd49d11e975c20e0565b1c0a534d&units=metric',
    function(err, data) {
        if(err !== null) {
            alert('예상치 못한 오류 발생.' + err);
        } else {
            loadWeather(data);
        }
    });

function loadWeather(data) {
    let location = document.querySelector('.location');
    let currentTime = document.querySelector('.current-time');
    let currentTemp = document.querySelector('.current-temp');
    let feelsLike = document.querySelector('.feels-like');
    let minTemp = document.querySelector('.min-temp');
    let maxTemp = document.querySelector('.max-temp');
    let mainweather = document.querySelector('.mainweather');
    let icon = document.querySelector('.icon');
    let weatherIcon = data.weather[0].icon;


    let date = new Date();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let hours = date.getHours();
    let minutes = date.getMinutes();

    location.append(data.name);
    currentTemp.append (`현재온도 : ${data.main.temp-1}°`);
    feelsLike.append (`체감온도 : ${data.main.feels_like-1}°`);
    currentTime.append (`${month}월 ${day}일 ${hours}시 ${minutes}분`);
    mainweather.append(data.weather[0].description);

    icon.innerHTML = `<img src = "https://openweathermap.org/img/wn/${weatherIcon}@2x.png" width=50% height=50%>`;

    location.reload();


}