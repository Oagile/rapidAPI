function () {
  var env = karate.env;
  if (env == null) {
    env = 'COVID19-DATA';
  }


  var config = {

  };

  if (env == 'COVID19-DATA') {
      config.baseURI='https://covid-19-data.p.rapidapi.com';
      config.host='covid-19-data.p.rapidapi.com'
      config.key='14f952cef7msh4fc80e77095ca87p13921fjsnb88934a54409'

  }

  karate.log('Environment is ::: ' + env + ' Base URL is ::: ' + config.baseURL);
  karate.configure('readTimeout', 6000000);
  karate.configure('connectTimeout', 50000);


  return config;
}
