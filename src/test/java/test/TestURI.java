package test;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

public class TestURI {

	//Test de validFragment(String value)
	@Test
	public void testValidFragment1(){
		String value = "truc";
		assertTrue(URI.validFragment(value));
	}
	@Test
	public void testValidFragment2(){
		String value = null;
		assertTrue(URI.validFragment(value));
	}
	
	//Test de validOpaquePart(String value)
	@Test
	public void testValidOpaquePart1(){
		String value = null;
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testValidOpaquePart2(){
		String value = "";
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testValidOpaquePart3(){
		String value = "truc#";
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testValidOpaquePart4(){
		String value = "/truc";
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testValidOpaquePart5(){
		String value = "truc";
		assertTrue(URI.validOpaquePart(value));
	}
	
	// Test de validScheme(String value)
	@Test
	public void testValidScheme1() {
		String value = "truc/";
		assertFalse(URI.validScheme(value));
	}
	@Test
	public void testValidScheme2() {
		String value = "truc?";
		assertFalse(URI.validScheme(value));	
	}
	@Test
	public void testValidScheme3() {
		String value = "truc#";
		assertFalse(URI.validScheme(value));
	}
	@Test
	public void testValidScheme4() {
		String value = null;
		assertTrue(URI.validScheme(value));
	}
	@Test
	public void testValidScheme5() {
		String value = "truc";
		assertTrue(URI.validScheme(value));
	}
	
	//Test de validDevice(String value)
	@Test
	public void testValidDevice1(){
		String value = "device/";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice2(){
		String value = "device?";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice3(){
		String value = "device#";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice4(){
		String value = "device";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice5(){
		String value = "device:";
		assertTrue(URI.validDevice(value));
	}
	@Test
	public void testValidDevice6(){
		String value = null;
		assertTrue(URI.validDevice(value));
	}
	
	//Test de validArchiveAuthority(String value)
	@Test
	public void testValidArchiveAuthority1(){
		String value = "authority#machin";
		assertFalse(URI.validArchiveAuthority(value));
	}
	@Test
	public void testValidArchiveAuthority2(){
		String value = "authority?truc";
		assertFalse(URI.validArchiveAuthority(value));
	}
	@Test
	public void testValidArchiveAuthority3(){
		String value = "authority";
		assertFalse(URI.validArchiveAuthority(value));
	}
	@Test
	public void testValidArchiveAuthority4(){
		String value = "authority!";
		assertTrue(URI.validArchiveAuthority(value));
	}
	
	//Test de validAuthority(String value)
	@Test
	public void testValidAuthority1(){
		String value = "authority#machin";
		assertFalse(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority2(){
		String value = "authority?truc";
		assertFalse(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority3(){
		String value = "authority/truc";
		assertFalse(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority4(){
		String value = "authority";
		assertTrue(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority5(){
		String value = null;
		assertTrue(URI.validAuthority(value));
	}
	
	//Test de validSegment(String value)
	@Test
	public void testValidSegment1(){
		String value = null;
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment2(){
		String value = "segment?";
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment3(){
		String value = "segment#";
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment4(){
		String value = "segment/";
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment5(){
		String value = "segment";
		assertTrue(URI.validSegment(value));
	}
	
	//Test de validSegments(String[] value)
	@Test
	public void testValidSegments1(){
		String[] values = null;
		assertFalse(URI.validSegments(values));
	}
	@Test
	public void testValidSegments2(){
		String[] values = {"segment1","segment2/","segment3"};
		assertFalse(URI.validSegments(values));
	}
	@Test
	public void testValidSegments3(){
		String[] values = {"segment1","segment2","segment3"};
		assertTrue(URI.validSegments(values));
	}
	
	//Test de validQuery(String value)
	@Test
	public void testValidQuery1(){
		String value = "query#truc";
		assertFalse(URI.validQuery(value));
	}
	@Test
	public void testValidQuery2(){
		String value = null;
		assertTrue(URI.validQuery(value));
	}
	@Test
	public void testValidQuery3(){
		String value = "query";
		assertTrue(URI.validQuery(value));
	}
			
	//Test de isArchiveScheme(String value)
	@Test
	public void testIsArchiveScheme1(){
		String value = "txt";
		assertFalse(URI.isArchiveScheme(value));
	}
	@Test
	public void testIsArchiveScheme2(){
		String value = "jar";
		assertTrue(URI.isArchiveScheme(value));
	}
	
	//Test de createGenericURI(String scheme, String opaquePart, String fragment)
	@Test(expected=IllegalArgumentException.class)
	public void testCreateGenericURI1(){
		String scheme = null;
		String opaquePart = "truc";
		String fragment = "truc";
		URI.createGenericURI(scheme, opaquePart, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateGenericURI2(){
		String scheme = "jar";
		String opaquePart = "truc";
		String fragment = "truc";
		URI.createGenericURI(scheme, opaquePart, fragment);
	}
	@Test
	public void testCreateGenericURI3(){
		String scheme = "truc";
		String opaquePart = "truc";
		String fragment = "truc";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertEquals(uri.toString(), "truc:truc#truc");
	}

	//Test de createHierarchicalURI(String scheme, String authority, String device, String query, String fragment)
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIA1(){
		String scheme = "truc";
		String authority = null;
		String device = null;
		String query = "truc";
		String fragment = "truc";
		URI.createHierarchicalURI(scheme, authority, device, query, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIA2(){
		String scheme = "jar";
		String authority = "truc";
		String device = "truc";
		String query = "truc";
		String fragment = "truc";
		URI.createHierarchicalURI(scheme, authority, device, query, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIA3(){
		String scheme = "truc";
		String authority = "truc";
		String device = "device/";
		String query = "truc";
		String fragment = "truc";
		URI.createHierarchicalURI(scheme, authority, device, query, fragment);
	}
	@Test
	public void testCreateHierarchicalURIA4(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.toString(), "scheme://authority/device:?query#fragment");
	}
	
	//Test de createHierarchicalURI(String scheme, String authority, String device, String[] segments, String query, String fragment)
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIB1(){
		String scheme = "jar";
		String authority = "authority";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIB2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String[] segments = {"foo/","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
	}
	@Test
	public void testCreateHierarchicalURIB3(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals(uri.toString(), "scheme://authority/device:/foo/bar?query#fragment");
	}
	
	//Test de createHierarchicalURI(String[] segments, String query, String fragment)
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIC1(){
		String[] segments = {"foo/","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIC2(){
		String[] segments = {"foo","bar"};
		String query = "query#";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
	}
	@Test
	public void testCreateHierarchicalURIC3(){
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals(uri.toString(), "foo/bar?query#fragment");
	}
	
	//Test de createURI(String uri)
	/*@Test(expected=IllegalArgumentException.class)//là c'est chiant
	public void testCreateURIA1(){
		String value = "";
		URI.createURI(value);
	}*/
	@Test
	public void testCreateURIA2(){
		String value = "foo://truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertEquals(uri.toString(), "foo://truc/bidule/machin");
	}
	
	//Test de createURI(String uri, boolean )
	/*@Test(expected=IllegalArgumentException.class)
	public void testCreateURIB1(){
		String value = "";
		boolean ignoreEsc = true;
		URI.createURI(value);
	}*/
	
	@Test()
	public void testCreateURIB2(){
		String value = "foo://truc/bidule%23machin#toto";
		boolean ignoreEsc = true;
		URI uri = URI.createURI(value, ignoreEsc);
		assertEquals(uri.toString(), "foo://truc/bidule%23machin#toto");
	}
	@Test
	public void testCreateURIB3(){
		String value = "foo://truc/bidule%23machin#toto";
		boolean ignoreEsc = false;
		URI uri = URI.createURI(value, ignoreEsc);
		assertEquals(uri.toString(), "foo://truc/bidule%2523machin#toto");
	}
	
	//Test de createURI(String uri, boolean ignoreEscape, int fragmentLocation)
	/*@Test(expected=IllegalArgumentException.class)
	public void testCreateURIC1(){
		String value = "";
		boolean ignoreEsc = true;
		URI.createURI(value);
	}*/
	@Test()
	public void testCreateURIC2(){
		String value = "foo://truc/bidule/machin#foo#bar";
		boolean ignoreEsc = false;
		URI uri = URI.createURI(value, ignoreEsc, URI.FRAGMENT_NONE);
		assertEquals(uri.toString(), "foo://truc/bidule/machin%23foo%23bar");
	}
	@Test
	public void testCreateURIC3(){
		String value = "foo://truc/bidule/machin#foo#bar";
		boolean ignoreEsc = false;
		URI uri = URI.createURI(value, ignoreEsc,URI.FRAGMENT_FIRST_SEPARATOR);
		assertEquals(uri.toString(), "foo://truc/bidule/machin#foo%23bar");
	}
	@Test
	public void testCreateURIC4(){
		String value = "foo://truc/bidule/machin#foo#bar";
		boolean ignoreEsc = false;
		URI uri = URI.createURI(value, ignoreEsc, URI.FRAGMENT_LAST_SEPARATOR);
		assertEquals(uri.toString(), "foo://truc/bidule/machin%23foo#bar");
	}
	
	//Test de createFileURI(String pathName)
	@Test
	public void testCreateFileURI1(){
		String value = "/truc/bidule/machin";
		URI uri = URI.createFileURI(value);
		assertEquals(uri.toString(), "file:/truc/bidule/machin");
	}
	@Test
	public void testCreateFileURI2(){
		String value = "/foo/truc/bidule#machin";
		URI uri = URI.createFileURI(value);
		assertEquals(uri.toString(), "file:/foo/truc/bidule%23machin");
	}
	
	//Test de createPlatformResourceURI(String pathname, boolean encode)
	@Test
	public void testCreatePlatformResourceURI1(){
		String pathName = "/project-name/path";
		boolean encode = true;
		URI uri = URI.createPlatformResourceURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/resource/project-name/path");
	}
	@Test
	public void testCreatePlatformResourceURI2(){
		String pathName = "project-name/path";
		boolean encode = true;
		URI uri = URI.createPlatformResourceURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/resource/project-name/path");
	}
	@Test
	public void testCreatePlatformResourceURI3(){
		String pathName = "/project-name/ path";
		boolean encode = true;
		URI uri = URI.createPlatformResourceURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/resource/project-name/%20path");
	}
	@Test
	public void testCreatePlatformResourceURI4(){
		String pathName = "/project-name/ path";
		boolean encode = false;
		URI uri = URI.createPlatformResourceURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/resource/project-name/ path");
	}
	
	//Test de createPlatformPluginURI(String pathname, boolean encode)
	@Test
	public void testCreatePlatformPluginURI1(){
		String pathName = "/plugin-id/path";
		boolean encode = true;
		URI uri = URI.createPlatformPluginURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/plugin/plugin-id/path");
	}
	@Test
	public void testCreatePlatformPluginURI2(){
		String pathName = "plugin-id/path";
		boolean encode = true;
		URI uri = URI.createPlatformPluginURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/plugin/plugin-id/path");
	}
	@Test
	public void testCreatePlatformPluginURI3(){
		String pathName = "/plugin-id/ path";
		boolean encode = true;
		URI uri = URI.createPlatformPluginURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/plugin/plugin-id/%20path");
	}
	@Test
	public void testCreatePlatformPluginURI4(){
		String pathName = "/plugin-id/ path";
		boolean encode = false;
		URI uri = URI.createPlatformPluginURI(pathName, encode);
		assertEquals(uri.toString(), "platform:/plugin/plugin-id/ path");
	}
	
	
	//Test de isCurrentDocumentReference()
	@Test
	public void testIsCurrentDocumentReference1(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertFalse(uri.isCurrentDocumentReference());
	}
	@Test
	public void testIsCurrentDocumentReference2(){
		String[] segments = {};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertTrue(uri.isCurrentDocumentReference());
	}
	
	//Test de isEmpty()
	@Test
	public void testIsEmpty1(){
		String[] segments = {};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.isEmpty());
	}
	@Test
	public void testIsEmpty2(){
		String[] segments = {};
		String query = null;
		String fragment = null;
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertTrue(uri.isEmpty());
	}
	
	//Test de isFile()
	@Test
	public void testIsFile1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.isFile());
	}
	@Test
	public void testIsFile2(){
		String[] segments = {"s1","s2"};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertTrue(uri.isFile());
	}
	@Test
	public void testIsFile3(){
		String value = "/truc/bidule/machin";
		URI uri = URI.createFileURI(value);
		assertTrue(uri.isFile());
	}
	
	//Test de isPlatform()
	@Test
	public void testIsPlatform1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.isPlatform());
	}
	@Test
	public void testIsPlatform2(){
		String pathName = "platform:/project-name";
		URI uri = URI.createURI(pathName);
		assertFalse(uri.isPlatform());
	}
	@Test
	public void testIsPlatform3(){
		String pathName = "platform:/project-name/path";
		URI uri = URI.createURI(pathName);
		assertTrue(uri.isPlatform());
	}
	
	//Test de isPlatformResource()
	@Test
	public void testIsPlatformResource1(){
		String pathName = "platform:/project-name/path";
		URI uri = URI.createURI(pathName);
		assertFalse(uri.isPlatformResource());
	}
	@Test
	public void testIsPlatformResource2(){
		String pathName = "platform:/resource/project-name/path";
		URI uri = URI.createURI(pathName);
		assertTrue(uri.isPlatformResource());
	}
	
	//Test de isPlatformPlugin()
	@Test
	public void testIsPlatformPlugin1(){
		String pathName = "platform:/pugin-id/path";
		URI uri = URI.createURI(pathName);
		assertFalse(uri.isPlatformPlugin());
	}
	@Test
	public void testIsPlatformPlugin2(){
		String pathName = "platform:/plugin/plugin-id/path";
		URI uri = URI.createURI(pathName);
		assertTrue(uri.isPlatformPlugin());
	}
	
	//Test de isArchive()
	@Test
	public void testIsArchive1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = null;
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertFalse(uri.isArchive());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testIsArchive2(){
		String scheme = "jar";
		String authority = "authority!";
		String device = "device";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
	}
	@Test
	public void testIsArchive3(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.isArchive());
	}
	@Test
	public void testIsArchive4(){
		String value = "foo://truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertFalse(uri.isArchive());
	}	
	@Test
	public void testIsArchive5(){
		String scheme = "jar";
		String authority = "authority!";
		String device = null;
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertTrue(uri.isArchive());
	}
	
	//Test de toString
	@Test
	public void testToString1(){
		String value = "foo://truc/bidule/machin";
		URI uri1 = URI.createURI(value);
		URI uri2 = URI.createURI(value+"3");
		assertFalse(uri1.toString().equals(uri2.toString()));
	}
	@Test
	public void testToString2(){
		String value = "foo://truc/bidule/machin";
		URI uri1 = URI.createURI(value);
		URI uri2 = URI.createURI(value);
		assertEquals(uri1.toString(), uri2.toString());
	}
	
	//Test de toFileString
	@Test
	public void testToFileString1(){
		String value = "/truc/bidule/machin";
		URI uri1 = URI.createFileURI(value);
		URI uri2 = URI.createFileURI(value+"3");
		assertFalse(uri1.toFileString().equals(uri2.toFileString()));
	}
	@Test
	public void testToFileString2(){
		String value = "/truc/bidule/machin";
		URI uri1 = URI.createFileURI(value);
		URI uri2 = URI.createFileURI(value);
		assertEquals(uri1.toFileString(), uri2.toFileString());
	}
	
	//Test de hashCode
	@Test
	public void testHashCode1(){
		String value = "foo://truc/bidule/machin";
		URI uri1 = URI.createURI(value);
		URI uri2 = URI.createURI(value+"3");
		assertFalse(uri1.hashCode() == uri2.hashCode());
	}
	@Test
	public void testHashCode2(){
		String value = "foo://truc/bidule/machin";
		URI uri1 = URI.createURI(value);
		URI uri2 = URI.createURI(value);
		assertEquals(uri1.hashCode(), uri2.hashCode());
	}
	
	//Test de scheme()
	@Test
	public void testScheme1(){
		String value = "truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertEquals(uri.scheme(), null);
	}
	@Test
	public void testScheme2(){
		String value = "foo://truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertEquals(uri.scheme(), "foo");
	}
	
	//Test de opaquePart()
	@Test
	public void testOpaquePart1(){
		String value = "truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertEquals(uri.opaquePart(), null);
	}
	@Test
	public void testOpaquePart2(){
		String scheme = "scheme";
		String opaquePart = "opaque";
		String fragment = "fragment";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertEquals(uri.opaquePart(), "opaque");
	}
	
	//Test de authority()
	@Test
	public void testAuthority1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals(uri.authority(), null);
	}
	@Test
	public void testAuthority2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.authority(), "authority");
	}
	
	//Test de userInfo()
	@Test
	public void testUserInfo1(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.userInfo(), null);
	}
	@Test
	public void testUserInfo2(){
		String scheme = "scheme";
		String authority = "user-info@authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.userInfo(), "user-info");
	}
	
	//Test de host()
	@Test
	public void testHost1(){
		String scheme = "scheme";
		String authority = null;
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.host(), null);
	}
	@Test
	public void testHost2(){
		String scheme = "scheme";
		String authority = "user-info@host:port";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.host(), "host");
	}
	
	//Test de port()
	@Test
	public void testPort1(){
		String scheme = "scheme";
		String authority = "user-info@host";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.port(), null);
	}
	@Test
	public void testPort2(){
		String scheme = "scheme";
		String authority = "user-info@host:port";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.port(), "port");
	}
	
	//Test de device()
	@Test
	public void testDevice1(){
		String scheme = "scheme";
		String authority = "user-info@host";
		String device = null;
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.device(), null);
	}
	@Test
	public void testDevice2(){
		String scheme = "scheme";
		String authority = "user-info@host:port";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.device(), "device:");
	}
	
	//Test de segments()
	@Test
	public void testSegments1(){	
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		String[] s = {};
		assertArrayEquals(s, uri.segments());
	}
	@Test
	public void testSegments2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		String[] s = {"foo","bar"};
		assertArrayEquals(s, uri.segments());
	}
	
	
	
	//Test de isRelative()
	@Test
	public void testIsRelative1(){
		String value = "foo://truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertFalse(uri.isRelative());
	}
	@Test
	public void testIsRelative2(){
		String value = "truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertTrue(uri.isRelative());
	}
	
	//Test de isHierarchical()
	@Test
	public void testIsHierachical1(){
		String value = "truc:";
		URI uri = URI.createURI(value);
		assertFalse(uri.isHierarchical());
	}
	@Test
	public void testIsHierachical2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertTrue(uri.isHierarchical());
	}
	
	//Test de hasAuthority()
	@Test
	public void testHasAuthority1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.hasAuthority());
	}
	@Test
	public void testHasAuthority2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertTrue(uri.hasAuthority());
	}
	
	//Test de hasOpaquePart()
	@Test
	public void testHasOpaquePart1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.hasOpaquePart());
	}
	@Test
	public void testHasOpaquePart2(){
		String scheme = "scheme";
		String opaquePart = "opaque";
		String fragment = "fragment";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertTrue(uri.hasOpaquePart());
	}
	
	//Test de hasDevice()
	@Test
	public void testHasDevice1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.hasDevice());
	}
	@Test
	public void testHasDevice2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertTrue(uri.hasDevice());
	}
	
	//Test de hasPath()
	@Test
	public void testHasPath1(){
		String scheme = "scheme";
		String opaquePart = "opaque";
		String fragment = "fragment";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertFalse(uri.hasPath());
	}
	@Test
	public void testHasPath2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertTrue(uri.hasPath());
	}
	
	//Test de hasAbsolutePath()
	@Test
	public void testHasAbsolutePath1(){
		String scheme = "scheme";
		String opaquePart = "opaque";
		String fragment = "fragment";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertFalse(uri.hasAbsolutePath());
	}
	@Test
	public void testHasAbsolutePath2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertTrue(uri.hasAbsolutePath());
	}
	
	//Test de hasRelativePath()
	@Test
	public void testHasRelativePath1(){
		String scheme = "scheme";
		String opaquePart = "opaque";
		String fragment = "fragment";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertFalse(uri.hasRelativePath());
	}
	@Test
	public void testHasRelativePath2(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertTrue(uri.hasRelativePath());
	}
	
	//Test de hasEmptyPath()
	@Test
	public void testHasEmptyPath1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.hasEmptyPath());
	}
	@Test
	public void testHasEmptyPath2(){
		String[] segments = {};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertTrue(uri.hasEmptyPath());
	}
	
	//Test de hasQuery()
	@Test
	public void testHasQuery1(){
		String[] segments = {"s1","s2"};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.hasQuery());
	}
	@Test
	public void testHasQuery2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertTrue(uri.hasQuery());
	}
	
	//Test de hasFragment()
	@Test
	public void testHasFragment1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = null;
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.hasFragment());
	}
	@Test
	public void testHasFragment2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertTrue(uri.hasFragment());
	}
	
}

