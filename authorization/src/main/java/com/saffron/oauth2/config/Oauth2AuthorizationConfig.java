package com.saffron.oauth2.config;


import com.saffron.oauth2.service.security.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

/**
 * id/password 기반 Oauth2 인증을 담당하는 서버
 * 다음 endpont가 자동 생성 된다.
 * /oauth/authorize
 * /oauth/token
 */
@RequiredArgsConstructor
@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;
    private final CustomUserDetailService userDetailService;

    private final AuthenticationManager authenticationManager;
    
    @Value("${security.oauth2.jwt.signkey}")
    private String signKey;

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) {
//        security.tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()") //allow check token
//                .allowFormAuthenticationForClients();
//    }

    /**
     * 클라이언트 정보 주입 방식을 jdbcdetail로 변경
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    	endpoints.authenticationManager(authenticationManager);
    }
    
//    //JDBC Token 방식    
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//    	endpoints.tokenStore(new JdbcTokenStore(dataSource)).userDetailsService(userDetailService));
//    }
    
//  /**
//  * 토큰 발급 방식을 JWT 토큰 방식으로 변경한다. 이렇게 하면 토큰 저장하는 DB Table은 필요가 없다.
//  */
// @Override
// public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//     super.configure(endpoints);
//     endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailService);
// }
    
//  @Bean
//  public JwtAccessTokenConverter jwtAccessTokenConverter() {
//      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//      converter.setSigningKey(signKey);  //jwt refresh 이용 가능
//      return converter;
//  }    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * 토큰 정보를 DB를 통해 관리한다.
//     */
////    @Override
////    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
////        endpoints.tokenStore(new JdbcTokenStore(dataSource)).userDetailsService(userDetailService);
////    }
//
//    /**
//     * 토큰 발급 방식을 JWT 토큰 방식으로 변경한다. 이렇게 하면 토큰 저장하는 DB Table은 필요가 없다.
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
//        endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailService);
//    }

    /**
     * jwt converter - signKey 공유 방식
     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey(signKey);
//        return converter;
//    }

//    /**
//     * jwt converter - 비대칭 키 sign
//     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new FileSystemResource("src/main/resources/oauth2jwt.jks"), "oauth2jwtpass".toCharArray());
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2jwt"));
//        return converter;
//    }
}
