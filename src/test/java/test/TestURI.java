package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

public class TestURI {

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
	
	//Test de SegmentsList()
	@Test(expected=UnsupportedOperationException.class)
	public void testSegmentsList1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		List<String> s = uri.segmentsList();
		s.add("truc");
	}
	@Test
	public void testSegmentsList2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		List<String> s = new ArrayList<String>();
		s.add("foo");
		s.add("bar");
		assertEquals(s, uri.segmentsList());
	}
	
	//Test de segmentCount()
	@Test
	public void testSegmentCount1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals(2, uri.segmentCount());
	}
	
	//Test de segment(int i)
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSegment1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("bar", uri.segment(2));
	}
	@Test
	public void testSegment2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("bar", uri.segment(1));
	}
	
	//Test de lastSegment()
	@Test
	public void testLastSegment1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals(null, uri.lastSegment());
	}
	@Test
	public void testLastSegment2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("bar", uri.lastSegment());
	}
	
	//Test de path()
	@Test
	public void testPath1(){
		String scheme = "scheme";
		String opaquePart = "opaque";
		String fragment = "fragment";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertEquals(null, uri.path());
	}	
	@Test
	public void testPath2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("/foo/bar", uri.path());
	}
	
	//Test de devicePath()
	@Test
	public void testDevicePath1(){
		String value = "truc:";
		URI uri = URI.createURI(value);
		assertEquals(null, uri.devicePath());
	}
	@Test
	public void testDevicePath2(){
		String scheme = "jar";
		String authority = "authority!";
		String device = null;
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("authority!/foo/bar", uri.devicePath());
	}
	@Test
	public void testDevicePath3(){
		String scheme = "scheme";
		String authority = null;
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("device:/foo/bar", uri.devicePath());
	}
	@Test
	public void testDevicePath4(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("//authority!/device:/foo/bar", uri.devicePath());
	}
	
	//Test de query()
	@Test
	public void testQuery1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals(null, uri.query());
	}
	@Test
	public void testQuery2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("query", uri.query());
	}
	
	//Test de appendQuery(String query)
	@Test(expected=IllegalArgumentException.class)
	public void testAppendQuery1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendQuery("query#truc");
	}
	@Test
	public void testAppendQuery2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query1";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendQuery("query");
		assertEquals("query", uri.query());
	}
	@Test
	public void testAppendQuery3(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendQuery("query");
		assertEquals("query", uri.query());
	}
	
	//Test de trimQuery()
	@Test
	public void testTrimQuery1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI new_uri = uri.trimQuery();
		assertEquals(uri, new_uri);
	}
	@Test
	public void testTrimQuery2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.trimQuery();
		assertEquals("scheme://authority!/device:/foo/bar#fragment", uri.toString());
	}
	
	//Test de fragment()
	@Test
	public void testFragment1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("fragment", uri.fragment());
	}
	@Test
	public void testFragment2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = null;
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals(null, uri.fragment());
	}
	
	//Test de appendFragment(String fragment)
	@Test
	public void testAppendFragment1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = null;
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendFragment("fragment");
		assertEquals("fragment", uri.fragment());
	}
	@Test
	public void testAppendFragment2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment1";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendFragment("fragment");
		assertEquals("fragment", uri.fragment());
	}
	
	//Test de trimFragment()
	@Test
	public void testTrimFragment1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = null;
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI new_uri = uri.trimFragment();
		assertEquals(uri, new_uri);
	}
	@Test
	public void testTrimFragment2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.trimFragment();
		assertEquals("scheme://authority!/device:/foo/bar?query", uri.toString());
	}
	
	//Test de resolve(String base)
	@Test(expected=IllegalArgumentException.class)
	public void testResolveA1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI base = URI.createHierarchicalURI(segments, query, fragment);//relative
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("", uri.resolve(base));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testResolveA2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI base = URI.createURI("here");//non-hierarchical
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("", uri.resolve(base));
	}
	@Test
	public void testResolveA3(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI base = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals("scheme://authority!/device:/foo/foo/bar?query#fragment", uri.resolve(base).toString());
	}
	
	
	//Test de resolve(String base, boolean preserveRootParents)
	@Test(expected=IllegalArgumentException.class)
	public void testResolveB1(){
		boolean preserve = true;
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI base = URI.createHierarchicalURI(segments, query, fragment);//relative
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("", uri.resolve(base,preserve));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testResolveB2(){
		boolean preserve = true;
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI base = URI.createURI("here");//non-hierarchical
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("", uri.resolve(base,preserve));
	}
	@Test
	public void testResolveB3(){
		boolean preserve = true;
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI base = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals("scheme://authority!/device:/foo/foo/bar?query#fragment", uri.resolve(base, preserve).toString());
	}
	@Test
	public void testResolveB4(){
		boolean preserve = false;
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI base = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals("scheme://authority!/device:/foo/foo/bar?query#fragment", uri.resolve(base, preserve).toString());
	}
	
	//Test de deresolve(String base)
	@Test
	public void testDeresolveA1(){
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createURI("here");//non-hierarchical
		assertEquals(uri.toString(), uri.deresolve(base).toString());
	}
	@Test
	public void testDeresolveA2(){
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createHierarchicalURI(segments, query, fragment);//relative
		assertEquals(uri.toString(), uri.deresolve(base).toString());
	}
	@Test
	public void testDeresolveA3(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI exp_uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals(exp_uri.toString(), uri.deresolve(base).toString());
	}
	
	//Test de deresolve(String base, boolean preserveRootParents, boolean anyRelPath, boolean shorterRelPath)
	@Test
	public void testDeresolveB1(){
		boolean preserve = true;
		boolean anyRel = true;
		boolean shorterRel = true;
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createURI("here");//non-hierarchical
		assertEquals(uri.toString(), uri.deresolve(base, preserve, anyRel, shorterRel).toString());
	}
	@Test
	public void testDeresolveB2(){
		boolean preserve = true;
		boolean anyRel = true;
		boolean shorterRel = true;
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createHierarchicalURI(segments, query, fragment);//relative
		assertEquals(uri.toString(), uri.deresolve(base, preserve, anyRel, shorterRel).toString());
	}
	@Test
	public void testDeresolveB3(){
		boolean preserve = true;
		boolean anyRel = true;
		boolean shorterRel = false;
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertTrue(uri.deresolve(base, preserve, anyRel, shorterRel).hasRelativePath());
	}
	@Test
	public void testDeresolveB4(){
		boolean preserve = true;
		boolean anyRel = false;
		boolean shorterRel = false;
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertTrue(uri.deresolve(base, preserve, anyRel, shorterRel).hasAbsolutePath());
	}
	@Test
	public void testDeresolveB5(){
		boolean preserve = true;
		boolean anyRel = false;
		boolean shorterRel = true;
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createURI("scheme://authority!/device:/foo/foo/bar?query#fragment");
		URI base = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI exp_uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals(exp_uri.toString(), uri.deresolve(base, preserve, anyRel, shorterRel).toString());
	}
	
	//Test de toFileString
	@Test
	public void testToFileString1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals(null, uri.toFileString());
	}
	@Test
	public void testToFileString2(){
		String[] segments = {"s1","s2"};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertEquals("s1/s2", uri.toFileString());
	}
	
	//Test de toPlateformString()
	@Test
	public void testToPlateformString1(){
		String pathName = "platform:/project-name";
		boolean decode = true;
		URI uri = URI.createURI(pathName);
		assertEquals(null,uri.toPlatformString(decode));
	}
	@Test
	public void testToPlateformString2(){
		String pathName = "platform:/project-name/path%23";
		boolean decode = true;
		URI uri = URI.createURI(pathName);
		assertEquals("/path#",uri.toPlatformString(decode));
	}
	@Test
	public void testToPlateformString3(){
		String pathName = "platform:/project-name/path%23";
		boolean decode = false;
		URI uri = URI.createURI(pathName);
		assertEquals("/path%23",uri.toPlatformString(decode));
	}
	
	
	//Test de appendSegment(String segment)
	@Test(expected=IllegalArgumentException.class)
	public void testAppendSegment1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendSegment("segment/");
	}
	@Test
	public void testAppendSegment2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendSegment("segment");
		String[] s = {"foo", "bar", "segment"};
		assertArrayEquals(s, uri.segments());
	}
	
	//Test de appendSegment(String segments)
	@Test(expected=IllegalArgumentException.class)
	public void testAppendSegments1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		String[] s = {"segment1", "segment2", "segment/"};
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendSegments(s);
	}
	@Test
	public void testAppendSegments2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		String[] new_s = {"segment1", "segment2"};
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendSegments(new_s);
		String[] s = {"foo", "bar", "segment1", "segment2"};
		assertArrayEquals(s, uri.segments());
	}
	
	//Test de trimSegments(int i)
	@Test
	public void testTrimSegments1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI new_uri = uri.trimSegments(2);
		assertEquals(uri, new_uri);
	}
	@Test
	public void testTrimSegments2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.trimSegments(3);
		String[] s = {};
		assertArrayEquals(s, uri.segments());
	}
	@Test
	public void testTrimSegments3(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.trimSegments(1);
		String[] s = {"foo"};
		assertArrayEquals(s, uri.segments());
	}
	
	//Test de hasTrailingPathSeparator()
	@Test
	public void testHasTrailingPathSeparator1(){
		String[] segments = {"s1","s2"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.hasTrailingPathSeparator());
	}
	@Test
	public void testHasTrailingPathSeparator2(){
		String[] segments = {"s1","s2",""};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertTrue(uri.hasTrailingPathSeparator());
	}
	
	//Test de fileExtension()
	@Test
	public void testFileExtension1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals(null, uri.fileExtension());
	}
	@Test
	public void testFileExtension2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar.txt"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		assertEquals("txt", uri.fileExtension());
	}
	
	//Test de appendFileExtension(String fileExtension)
	@Test
	public void testAppendFileExtension1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar.txt"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendFileExtension("html");
		assertEquals("html", uri.fileExtension());
	}
	@Test
	public void testAppendFileExtension2(){
		String scheme = "scheme";
		String opaquePart = "opaque";
		String fragment = "fragment";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		URI new_uri = uri.appendFileExtension("txt");
		assertEquals(new_uri, uri);
	}
	@Test
	public void testAppendFileExtension3(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		uri = uri.appendFileExtension("txt");
		assertEquals("txt", uri.fileExtension());
	}
	
	//Test de trimFileExtension()
	@Test
	public void testTrimFileExtension1(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		URI new_uri = uri.trimFileExtension();
		assertEquals(uri, new_uri);
	}
	@Test
	public void testTrimFileExtension2(){
		String scheme = "scheme";
		String authority = "authority!";
		String device = "device:";
		String[] segments = {"foo","bar.txt"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, segments, query, fragment);
		String new_scheme = "scheme";
		String new_authority = "authority!";
		String new_device = "device:";
		String[] new_segments = {"foo","bar"};
		String new_query = "query";
		String new_fragment = "fragment";
		URI new_uri = URI.createHierarchicalURI(new_scheme, new_authority, new_device, new_segments, new_query, new_fragment);
		uri = uri.trimFileExtension();
		assertEquals(new_uri, uri);
	}
	
	//Test de isPrefix()
	@Test
	public void testIsPrefix1(){
		String[] segments = {"foo","bar"};
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.isPrefix());
	}
	@Test
	public void testIsPrefix2(){
		String[] segments = {"foo","bar",""};
		String query = null;
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.isPrefix());
	}
	@Test
	public void testIsPrefix3(){
		String[] segments = {"foo","bar",""};
		String query = "query";
		String fragment = null;
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertFalse(uri.isPrefix());
	}
	@Test
	public void testIsPrefix4(){
		String[] segments = {"foo","bar",""};
		String query = null;
		String fragment = null;
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		assertTrue(uri.isPrefix());
	}
	
	//Test de replacePrefix(String oldPrefix, String newPrefix)
	@Test(expected=IllegalArgumentException.class)
	public void testReplacePrefix1(){
		String[] segments = {"foo","bar",""};
		String[] new_segments = {"bar","bar",""};
		String query = "query";
		String fragment = "fragment";
		String old_query = "query";
		String old_fragment = null;
		String new_query = null;
		String new_fragment = null;
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		URI old_prefix = URI.createHierarchicalURI(segments, old_query, old_fragment);
		URI new_prefix = URI.createHierarchicalURI(new_segments, new_query, new_fragment);
		uri.replacePrefix(old_prefix, new_prefix);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testReplacePrefix2(){
		String[] segments = {"foo","bar",""};
		String[] new_segments = {"bar","bar",""};
		String query = "query";
		String fragment = "fragment";
		String old_query = null;
		String old_fragment = null;
		String new_query = null;
		String new_fragment = "fragment";
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		URI old_prefix = URI.createHierarchicalURI(segments, old_query, old_fragment);
		URI new_prefix = URI.createHierarchicalURI(new_segments, new_query, new_fragment);
		uri.replacePrefix(old_prefix, new_prefix);
	}
	@Test
	public void testReplacePrefix3(){
		String[] segments = {"foo","bar",""};
		String[] new_segments = {"bar","bar",""};
		String query = "query";
		String fragment = "fragment";
		String old_query = null;
		String old_fragment = null;
		String new_query = null;
		String new_fragment = null;
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		URI old_prefix = URI.createHierarchicalURI(new_segments, old_query, old_fragment);
		URI new_prefix = URI.createHierarchicalURI(new_segments, new_query, new_fragment);
		
		assertEquals(null, uri.replacePrefix(old_prefix, new_prefix));
	}
	@Test
	public void testReplacePrefix4(){
		String[] segments = {"foo","bar",""};
		String[] new_segments = {"bar","bar",""};
		String query = "query";
		String fragment = "fragment";
		String old_query = null;
		String old_fragment = null;
		String new_query = null;
		String new_fragment = null;
		URI uri = URI.createHierarchicalURI(segments, query, fragment);
		URI old_prefix = URI.createHierarchicalURI(segments, old_query, old_fragment);
		URI new_prefix = URI.createHierarchicalURI(new_segments, new_query, new_fragment);
		
		assertEquals("bar/bar/#fragment", uri.replacePrefix(old_prefix, new_prefix).toString());
	}
	
	//Test de encodeOpaquePart(String value, boolean ignoreEscaped)
	@Test
	public void testEncodeOpaquePart1(){
		String value = "truc#";
		boolean ignore = true;
		assertEquals("truc%23",URI.encodeOpaquePart(value, ignore));
	}
	@Test
	public void testEncodeOpaquePart2(){
		String value = "truc?";
		boolean ignore = true;
		assertEquals("truc?",URI.encodeOpaquePart(value, ignore));
	}
	@Test
	public void testEncodeOpaquePart3(){
		String value = "truc%25#";
		boolean ignore = true;
		assertEquals("truc%25%23",URI.encodeOpaquePart(value, ignore));
	}
	@Test
	public void testEncodeOpaquePart4(){
		String value = "truc%25#";
		boolean ignore = false;
		assertEquals("truc%2525%23",URI.encodeOpaquePart(value, ignore));
	}
		
	//Test de encodeAuthority(String value, boolean ignoreEscaped)
	@Test
	public void testEncodeAuthority1(){
		String value = "truc#";
		boolean ignore = true;
		assertEquals("truc%23",URI.encodeAuthority(value, ignore));
	}
	@Test
	public void testEncodeAuthority2(){
		String value = "truc!";
		boolean ignore = true;
		assertEquals("truc!",URI.encodeAuthority(value, ignore));
	}
	@Test
	public void testEncodeAuthority3(){
		String value = "truc%25#";
		boolean ignore = true;
		assertEquals("truc%25%23",URI.encodeAuthority(value, ignore));
	}
	@Test
	public void testEncodeAuthority4(){
		String value = "truc%25#";
		boolean ignore = false;
		assertEquals("truc%2525%23",URI.encodeAuthority(value, ignore));
	}
	
	//Test de encodeSegment(String value, boolean ignoreEscaped)
	@Test
	public void testEncodeSegment1(){
		String value = "truc#";
		boolean ignore = true;
		assertEquals("truc%23",URI.encodeSegment(value, ignore));
	}
	@Test
	public void testEncodeSegment2(){
		String value = "truc!";
		boolean ignore = true;
		assertEquals("truc!",URI.encodeSegment(value, ignore));
	}
	@Test
	public void testEncodeSegment3(){
		String value = "truc%25#";
		boolean ignore = true;
		assertEquals("truc%25%23",URI.encodeSegment(value, ignore));
	}
	@Test
	public void testEncodeSegment4(){
		String value = "truc%25#";
		boolean ignore = false;
		assertEquals("truc%2525%23",URI.encodeSegment(value, ignore));
	}
	
	//Test de encodeQuery(String value, boolean ignoreEscaped)
	@Test
	public void testEncodeQuery1(){
		String value = "truc#";
		boolean ignore = true;
		assertEquals("truc%23",URI.encodeQuery(value, ignore));
	}
	@Test
	public void testEncodeQuery2(){
		String value = "truc!";
		boolean ignore = true;
		assertEquals("truc!",URI.encodeQuery(value, ignore));
	}
	@Test
	public void testEncodeQuery3(){
		String value = "truc%25#";
		boolean ignore = true;
		assertEquals("truc%25%23",URI.encodeQuery(value, ignore));
	}
	@Test
	public void testEncodeQuery4(){
		String value = "truc%25#";
		boolean ignore = false;
		assertEquals("truc%2525%23",URI.encodeQuery(value, ignore));
	}
	
	//Test de encodeFragment(String value, boolean ignoreEscaped)
	@Test
	public void testEncodeFragment1(){
		String value = "truc#";
		boolean ignore = true;
		assertEquals("truc%23",URI.encodeFragment(value, ignore));
	}
	@Test
	public void testEncodeFragment2(){
		String value = "truc!";
		boolean ignore = true;
		assertEquals("truc!",URI.encodeFragment(value, ignore));
	}
	@Test
	public void testEncodeFragment3(){
		String value = "truc%25#";
		boolean ignore = true;
		assertEquals("truc%25%23",URI.encodeFragment(value, ignore));
	}
	@Test
	public void testEncodeFragment4(){
		String value = "truc%25#";
		boolean ignore = false;
		assertEquals("truc%2525%23",URI.encodeFragment(value, ignore));
	}
	
	//Test de decode(String value)
	@Test
	public void testDecode1(){
		String value="truc%25%23";
		assertEquals("truc%#",URI.decode(value));
	}
	@Test
	public void testDecode2(){
		String value="truc!";
		assertEquals("truc!",URI.decode(value));
	}
	@Test
	public void testDecode3(){
		String value="truc%2";
		assertEquals("truc%2",URI.decode(value));
	}
	
	
	
}