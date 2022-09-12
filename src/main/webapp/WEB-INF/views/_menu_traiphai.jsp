 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <div class="col-md-3">
        <div class="category leftbar">
          <h3 class="title">
            Producer
          </h3>
          <ul>
          <li>
             <a href="/controller"> 
             All Producer
              </a>
            </li>
          <c:forEach var="nsx" items="${listNSX }">          
           <li>
             <a href="timsptheonsx?maNSX=${nsx.maNSX }"> ${nsx.tenNSX }
              </a>
            </li>
          </c:forEach>          
       
          </ul>
        </div>
        <div class="clearfix">
        </div>
         
        <div class="clearfix">
        </div>
        
        <div class="others leftbar">
          <h3 class="title">
           Contact us
          </h3>
        </div>
        <div class="clearfix">
        </div>
         
        <div class="clearfix">
        </div>
        <div class="fbl-box leftbar">
          <h3 class="title">
            Facebook
          </h3>
          <span class="likebutton">
            <a href="#">
              <img src=" " alt="">
            </a>
          </span>
          <p>
            12k people like Flat Shop.
          </p>
          <ul>
            <li>
              <a href="#">
              </a>
            </li>
            <li>
              <a href="#">
              </a>
            </li>
            <li>
              <a href="#">
              </a>
            </li>
            <li>
              <a href="#">
              </a>
            </li>
            <li>
              <a href="#">
              </a>
            </li>
            <li>
              <a href="#">
              </a>
            </li>
            <li>
              <a href="#">
              </a>
            </li>
            <li>
              <a href="#">
              </a>
            </li>
          </ul>
          <div class="fbplug">
            <a href="#">
              <span>
                <img src="" alt="">
              </span>
              Facebook social plugin
            </a>
          </div>
        </div>
        <div class="clearfix">
        </div>
        <div class="leftbanner">
          <img src="" alt="">
        </div>
      </div>