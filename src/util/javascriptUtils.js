function getImgUrl(img) {
  var images = require.context("../assets/img/", false);
  return images("./" + img);
}
export { getImgUrl };
