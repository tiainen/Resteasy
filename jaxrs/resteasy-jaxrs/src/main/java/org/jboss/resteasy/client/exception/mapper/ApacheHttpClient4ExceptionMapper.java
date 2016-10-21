package org.jboss.resteasy.client.exception.mapper;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.MalformedChunkCodingException;
import cz.msebera.android.httpclient.MethodNotSupportedException;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.UnsupportedHttpVersionException;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.InvalidCredentialsException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.CircularRedirectException;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.RedirectException;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.HttpHostConnectException;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.impl.auth.NTLMEngineException;
import cz.msebera.android.httpclient.impl.client.TunnelRefusedException;
import org.jboss.resteasy.client.exception.ResteasyAuthenticationException;
import org.jboss.resteasy.client.exception.ResteasyCircularRedirectException;
import org.jboss.resteasy.client.exception.ResteasyClientException;
import org.jboss.resteasy.client.exception.ResteasyClientProtocolException;
import org.jboss.resteasy.client.exception.ResteasyConnectTimeoutException;
import org.jboss.resteasy.client.exception.ResteasyConnectionClosedException;
import org.jboss.resteasy.client.exception.ResteasyConnectionPoolTimeoutException;
import org.jboss.resteasy.client.exception.ResteasyCookieRestrictionViolationException;
import org.jboss.resteasy.client.exception.ResteasyHttpException;
import org.jboss.resteasy.client.exception.ResteasyHttpHostConnectException;
import org.jboss.resteasy.client.exception.ResteasyIOException;
import org.jboss.resteasy.client.exception.ResteasyInvalidCredentialsException;
import org.jboss.resteasy.client.exception.ResteasyMalformedChallengeException;
import org.jboss.resteasy.client.exception.ResteasyMalformedChunkCodingException;
import org.jboss.resteasy.client.exception.ResteasyMalformedCookieException;
import org.jboss.resteasy.client.exception.ResteasyMethodNotSupportedException;
import org.jboss.resteasy.client.exception.ResteasyNTLMEngineException;
import org.jboss.resteasy.client.exception.ResteasyNoHttpResponseException;
import org.jboss.resteasy.client.exception.ResteasyNonRepeatableRequestException;
import org.jboss.resteasy.client.exception.ResteasyProtocolException;
import org.jboss.resteasy.client.exception.ResteasyRedirectException;
import org.jboss.resteasy.client.exception.ResteasyTunnelRefusedException;
import org.jboss.resteasy.client.exception.ResteasyUnsupportedHttpVersionException;

import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * 
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 *
 * Copyright Jul 28, 2012
 */
@Provider
public class ApacheHttpClient4ExceptionMapper implements ClientExceptionMapper<Exception>
{
   @Override
   public ResteasyClientException toException(Exception exception)
   {
      if (exception instanceof IOException)
      {
         return mapIOException(IOException.class.cast(exception));
      }
      if (exception instanceof HttpException)
      {
         return mapHttpException(HttpException.class.cast(exception));
      }
      return new ResteasyClientException("Unexpected exception type", exception);
   }

   private ResteasyClientException mapIOException(IOException e)
   {
      if (ClientProtocolException.class.equals(e.getClass()))
      {
         return new ResteasyClientProtocolException(e);
      }
      if (ConnectionClosedException.class.equals(e.getClass()))
      {
         return new ResteasyConnectionClosedException(e);
      }
      if (ConnectionPoolTimeoutException.class.equals(e.getClass()))
      {
         return new ResteasyConnectionPoolTimeoutException(e);
      }
      if (ConnectTimeoutException.class.equals(e.getClass()))
      {
         return new ResteasyConnectTimeoutException(e);
      }
      if (HttpHostConnectException.class.equals(e.getClass()))
      {
         return new ResteasyHttpHostConnectException(e);
      }
      if (MalformedChunkCodingException.class.equals(e.getClass()))
      {
         return new ResteasyMalformedChunkCodingException(e);
      }
      if (NoHttpResponseException.class.equals(e.getClass()))
      {
         return new ResteasyNoHttpResponseException(e);
      }
      if (NoHttpResponseException.class.equals(e.getClass()))
      {
         return new ResteasyNoHttpResponseException(e);
      }
      return new ResteasyIOException("IOException", e);
   }
   
   private ResteasyClientException mapHttpException(HttpException e)
   {
      if (AuthenticationException.class.equals(e.getClass()))
      {
         return new ResteasyAuthenticationException(e);
      }
      if (CircularRedirectException.class.equals(e.getClass()))
      {
         return new ResteasyCircularRedirectException(e);
      }
      if (CookieRestrictionViolationException.class.equals(e.getClass()))
      {
         return new ResteasyCookieRestrictionViolationException(e);
      }
      if (InvalidCredentialsException.class.equals(e.getClass()))
      {
         return new ResteasyInvalidCredentialsException(e);
      }
      if (MalformedChallengeException.class.equals(e.getClass()))
      {
         return new ResteasyMalformedChallengeException(e);
      }
      if (MalformedCookieException.class.equals(e.getClass()))
      {
         return new ResteasyMalformedCookieException(e);
      }
      if (MethodNotSupportedException.class.equals(e.getClass()))
      {
         return new ResteasyMethodNotSupportedException(e);
      }
      if (NonRepeatableRequestException.class.equals(e.getClass()))
      {
         return new ResteasyNonRepeatableRequestException(e);
      }
      if (NTLMEngineException.class.equals(e.getClass()))
      {
         return new ResteasyNTLMEngineException(e);
      }
      if (ProtocolException.class.equals(e.getClass()))
      {
         return new ResteasyProtocolException(e);
      }
      if (RedirectException.class.equals(e.getClass()))
      {
         return new ResteasyRedirectException(e);
      }
      if (TunnelRefusedException.class.equals(e.getClass()))
      {
         return new ResteasyTunnelRefusedException(e);
      }
      if (UnsupportedHttpVersionException.class.equals(e.getClass()))
      {
         return new ResteasyUnsupportedHttpVersionException(e);
      }
      return new ResteasyHttpException("HttpException", e);
   }
}