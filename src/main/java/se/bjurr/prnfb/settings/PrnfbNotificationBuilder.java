package se.bjurr.prnfb.settings;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Strings.emptyToNull;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.UUID.randomUUID;
import static se.bjurr.prnfb.http.UrlInvoker.HTTP_METHOD.GET;

import java.util.List;
import java.util.UUID;

import se.bjurr.prnfb.http.UrlInvoker.HTTP_METHOD;
import se.bjurr.prnfb.listener.PrnfbPullRequestAction;
import se.bjurr.prnfb.service.PrnfbRenderer.ENCODE_FOR;

import com.atlassian.bitbucket.pull.PullRequestState;

public class PrnfbNotificationBuilder {
  public static PrnfbNotificationBuilder prnfbNotificationBuilder() {
    return new PrnfbNotificationBuilder();
  }

  public PrnfbNotificationBuilder(
      String filterRegexp,
      String filterString,
      List<PrnfbHeader> headers,
      String injectionUrl,
      String injectionUrlRegexp,
      HTTP_METHOD method,
      String name,
      String password,
      String postContent,
      String projectKey,
      String proxyPassword,
      Integer proxyPort,
      String proxyServer,
      String proxyUser,
      String repositorySlug,
      TRIGGER_IF_MERGE triggerIfCanMerge,
      List<PullRequestState> triggerIgnoreStateList,
      List<PrnfbPullRequestAction> triggers,
      boolean updatePullRequestRefs,
      String url,
      String user,
      UUID uuid,
      ENCODE_FOR postContentEncoding,
      String proxySchema) {
    this.filterRegexp = filterRegexp;
    this.filterString = filterString;
    this.headers = headers;
    this.injectionUrl = injectionUrl;
    this.injectionUrlRegexp = injectionUrlRegexp;
    this.method = method;
    this.name = name;
    this.password = password;
    this.postContent = postContent;
    this.projectKey = projectKey;
    this.proxyPassword = proxyPassword;
    this.proxyPort = proxyPort;
    this.proxyServer = proxyServer;
    this.proxyUser = proxyUser;
    this.repositorySlug = repositorySlug;
    this.triggerIfCanMerge = triggerIfCanMerge;
    this.triggerIgnoreStateList = triggerIgnoreStateList;
    this.triggers = triggers;
    this.updatePullRequestRefs = updatePullRequestRefs;
    this.url = url;
    this.user = user;
    this.uuid = uuid;
    this.postContentEncoding = postContentEncoding;
    this.proxySchema = proxySchema;
  }

  public static PrnfbNotificationBuilder prnfbNotificationBuilder(PrnfbNotification from) {
    final PrnfbNotificationBuilder b = new PrnfbNotificationBuilder();

    b.uuid = from.getUuid();
    b.password = from.getPassword().orNull();
    b.triggers = from.getTriggers();
    b.updatePullRequestRefs = from.isUpdatePullRequestRefs();
    b.url = from.getUrl();
    b.user = from.getUser().orNull();
    b.filterRegexp = from.getFilterRegexp().orNull();
    b.filterString = from.getFilterString().orNull();
    b.method = from.getMethod();
    b.postContent = from.getPostContent().orNull();
    b.headers = from.getHeaders();
    b.triggerIgnoreStateList = from.getTriggerIgnoreStateList();
    b.proxyUser = from.getProxyUser().orNull();
    b.proxyPassword = from.getProxyPassword().orNull();
    b.proxyServer = from.getProxyServer().orNull();
    b.proxySchema = from.getProxySchema().orNull();
    b.proxyPort = from.getProxyPort();
    b.projectKey = from.getProjectKey().orNull();
    b.repositorySlug = from.getRepositorySlug().orNull();
    b.name = from.getName();
    b.injectionUrl = from.getInjectionUrl().orNull();
    b.injectionUrlRegexp = from.getInjectionUrlRegexp().orNull();
    b.triggerIfCanMerge = from.getTriggerIfCanMerge();
    b.postContentEncoding = from.getPostContentEncoding();
    return b;
  }

  private String filterRegexp;
  private String filterString;
  private List<PrnfbHeader> headers = newArrayList();
  private String injectionUrl;
  private String injectionUrlRegexp;
  private HTTP_METHOD method;
  private String name;
  private String password;
  private String postContent;
  private String projectKey;
  private String proxyPassword;
  private Integer proxyPort;
  private String proxyServer;
  private String proxyUser;
  private String repositorySlug;
  private TRIGGER_IF_MERGE triggerIfCanMerge;
  private List<PullRequestState> triggerIgnoreStateList = newArrayList();
  private List<PrnfbPullRequestAction> triggers = newArrayList();
  private boolean updatePullRequestRefs;
  private String url;
  private String user;
  private UUID uuid;
  private ENCODE_FOR postContentEncoding;
  private String proxySchema;

  private PrnfbNotificationBuilder() {
    this.uuid = randomUUID();
  }

  public ENCODE_FOR getPostContentEncoding() {
    return postContentEncoding;
  }

  public PrnfbNotification build() throws ValidationException {
    return new PrnfbNotification(this);
  }

  public String getFilterRegexp() {
    return this.filterRegexp;
  }

  public String getFilterString() {
    return this.filterString;
  }

  public List<PrnfbHeader> getHeaders() {
    return this.headers;
  }

  public String getInjectionUrl() {
    return this.injectionUrl;
  }

  public String getInjectionUrlRegexp() {
    return this.injectionUrlRegexp;
  }

  public HTTP_METHOD getMethod() {
    return this.method;
  }

  public String getName() {
    return this.name;
  }

  public String getPassword() {
    return this.password;
  }

  public String getPostContent() {
    return this.postContent;
  }

  public String getProjectKey() {
    return this.projectKey;
  }

  public String getProxyPassword() {
    return this.proxyPassword;
  }

  public Integer getProxyPort() {
    return this.proxyPort;
  }

  public String getProxyServer() {
    return this.proxyServer;
  }

  public String getProxySchema() {
    return proxySchema;
  }

  public String getProxyUser() {
    return this.proxyUser;
  }

  public String getRepositorySlug() {
    return this.repositorySlug;
  }

  public TRIGGER_IF_MERGE getTriggerIfCanMerge() {
    return this.triggerIfCanMerge;
  }

  public List<PullRequestState> getTriggerIgnoreStateList() {
    return this.triggerIgnoreStateList;
  }

  public List<PrnfbPullRequestAction> getTriggers() {
    return this.triggers;
  }

  public boolean isUpdatePullRequestRefs() {
    return this.updatePullRequestRefs;
  }

  public String getUrl() {
    return this.url;
  }

  public String getUser() {
    return this.user;
  }

  public UUID getUuid() {
    return this.uuid;
  }

  public UUID getUUID() {
    return this.uuid;
  }

  public PrnfbNotificationBuilder setHeaders(List<PrnfbHeader> headers) {
    this.headers = headers;
    return this;
  }

  public PrnfbNotificationBuilder setTriggerIgnoreState(
      List<PullRequestState> triggerIgnoreStateList) {
    this.triggerIgnoreStateList = triggerIgnoreStateList;
    return this;
  }

  public PrnfbNotificationBuilder setTriggers(List<PrnfbPullRequestAction> triggers) {
    this.triggers = triggers;
    return this;
  }

  public PrnfbNotificationBuilder setUpdatePullRequestRefs(boolean updatePullRequestRefs) {
    this.updatePullRequestRefs = updatePullRequestRefs;
    return this;
  }

  public PrnfbNotificationBuilder withFilterRegexp(String filterRegexp) {
    this.filterRegexp = emptyToNull(filterRegexp);
    return this;
  }

  public PrnfbNotificationBuilder withFilterString(String filterString) {
    this.filterString = emptyToNull(filterString);
    return this;
  }

  public PrnfbNotificationBuilder withHeader(String name, String value) {
    this.headers.add(new PrnfbHeader(name, value));
    return this;
  }

  public PrnfbNotificationBuilder withInjectionUrl(String injectionUrl) {
    this.injectionUrl = emptyToNull(injectionUrl);
    return this;
  }

  public PrnfbNotificationBuilder withInjectionUrlRegexp(String injectionUrlRegexp) {
    this.injectionUrlRegexp = emptyToNull(injectionUrlRegexp);
    return this;
  }

  public PrnfbNotificationBuilder withMethod(HTTP_METHOD method) {
    this.method = firstNonNull(method, GET);
    return this;
  }

  public PrnfbNotificationBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public PrnfbNotificationBuilder withPassword(String password) {
    this.password = emptyToNull(password);
    return this;
  }

  public PrnfbNotificationBuilder withPostContent(String postContent) {
    this.postContent = emptyToNull(postContent);
    return this;
  }

  public PrnfbNotificationBuilder withProjectKey(String projectKey) {
    this.projectKey = projectKey;
    return this;
  }

  public PrnfbNotificationBuilder withProxyPassword(String s) {
    this.proxyPassword = emptyToNull(s);
    return this;
  }

  public PrnfbNotificationBuilder withProxyPort(Integer s) {
    this.proxyPort = s;
    return this;
  }

  public PrnfbNotificationBuilder withProxyServer(String s) {
    this.proxyServer = emptyToNull(s);
    return this;
  }

  public PrnfbNotificationBuilder withProxyUser(String s) {
    this.proxyUser = emptyToNull(s);
    return this;
  }

  public PrnfbNotificationBuilder withRepositorySlug(String repositorySlug) {
    this.repositorySlug = repositorySlug;
    return this;
  }

  public PrnfbNotificationBuilder withTrigger(PrnfbPullRequestAction trigger) {
    this.triggers.add(trigger);
    return this;
  }

  public PrnfbNotificationBuilder withUpdatePullRequestRefs(boolean updatePullRequestRefs) {
    this.updatePullRequestRefs = updatePullRequestRefs;
    return this;
  }

  public PrnfbNotificationBuilder withTriggerIfCanMerge(TRIGGER_IF_MERGE triggerIfCanMerge) {
    this.triggerIfCanMerge = triggerIfCanMerge;
    return this;
  }

  public PrnfbNotificationBuilder withTriggerIgnoreState(PullRequestState triggerIgnoreState) {
    this.triggerIgnoreStateList.add(triggerIgnoreState);
    return this;
  }

  public PrnfbNotificationBuilder withUrl(String url) {
    this.url = url;
    return this;
  }

  public PrnfbNotificationBuilder withUser(String user) {
    this.user = emptyToNull(user);
    return this;
  }

  public PrnfbNotificationBuilder withPostContentEncoding(ENCODE_FOR postContentEncoding) {
    this.postContentEncoding = postContentEncoding;
    return this;
  }

  public PrnfbNotificationBuilder withUuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  public PrnfbNotificationBuilder withProxySchema(String proxySchema) {
    this.proxySchema = proxySchema;
    return this;
  }
}
